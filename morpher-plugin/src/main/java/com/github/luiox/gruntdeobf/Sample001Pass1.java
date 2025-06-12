package com.github.luiox.gruntdeobf;

import com.github.luiox.morpher.asm.matcher.MatchRule;
import com.github.luiox.morpher.asm.matcher.PatternMatcher;
import com.github.luiox.morpher.asm.matcher.StepUtil;
import com.github.luiox.morpher.transformer.MethodPass;
import com.github.luiox.morpher.transformer.PassContext;
import com.github.luiox.morpher.transformer.PassInfo;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.MethodNode;

@PassInfo(name = "Sample001Pass1", description = "处理a^a的pass")
public class Sample001Pass1 extends MethodPass {

    static PatternMatcher matcher = new PatternMatcher();

    static {
        MatchRule rule = new MatchRule()
                .addStep(StepUtil.loadInt())
                .addStep(StepUtil.dup())
                .addStep(StepUtil.ixor())
                .setStrategy(ctx -> {
                    ctx.builder.iconst_0();
                });
        matcher.addRule(rule);
    }

    @Override
    public void run(@NotNull MethodNode methodNode, @NotNull PassContext passContext) {
        if(methodNode.instructions == null || methodNode.instructions.size() == 0){
            return;
        }
        methodNode.instructions = matcher.apply(methodNode.instructions);
    }
}
