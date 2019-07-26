package art.redoc.sourcegenerator;

import art.redoc.SourceGenerator;

public class GeneratorStarter {
    public static void main(String[] args) throws ClassNotFoundException {
        SourceGenerator.generate("art.redoc.business.test.model",
                new String[]{"Test"},
                "model",
                SourceGenerator.Output.FILE,
                true,
                SourceGenerator.IDType.LONG);
    }
}
