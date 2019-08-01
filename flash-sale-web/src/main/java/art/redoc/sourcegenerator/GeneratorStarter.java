package art.redoc.sourcegenerator;

import art.redoc.SourceGenerator;

public class GeneratorStarter {
    public static void main(String[] args) throws ClassNotFoundException {
        SourceGenerator.generate("art.redoc.business.goods.model",
                new String[]{"User"},
                "model",
                SourceGenerator.Output.FILE,
                true,
                SourceGenerator.IDType.LONG);
    }
}
