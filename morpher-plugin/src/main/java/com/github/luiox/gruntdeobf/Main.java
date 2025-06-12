package com.github.luiox.gruntdeobf;

import com.github.luiox.morpher.jar.FullJarCaches;
import com.github.luiox.morpher.jar.SimpleJarReader;
import com.github.luiox.morpher.jar.SimpleJarWriter;
import com.github.luiox.morpher.transformer.PassContext;
import com.github.luiox.morpher.transformer.SimplePassRunner;

public class Main {
    public static void main(String[] args) {
        PassContext context = new PassContext();
        context.jarCaches = new FullJarCaches();
        context.jarCaches.read(new SimpleJarReader("sample-001.jar"));

        SimplePassRunner runner = new SimplePassRunner();
        runner.addPass(new Sample001Pass1());
        runner.transform(context);

        context.jarCaches.write(new SimpleJarWriter("output.jar"));
    }
}
