package art.redoc;


import art.redoc.sourcegenerator.impl.ControllerGenerator;
import art.redoc.sourcegenerator.impl.ConvertorGenerator;
import art.redoc.sourcegenerator.impl.DtoGenerator;
import art.redoc.sourcegenerator.impl.RepositoryGenerator;
import art.redoc.sourcegenerator.impl.ServiceGenerator;
import art.redoc.sourcegenerator.impl.ServiceImplGenerator;
import art.redoc.sourcegenerator.utils.GeneratorConfiguration;

public class SourceGenerator {

    enum Output {
        file, console
    }

    /**
     * 请按照如下方式配置启动参数: <br>
     * 1. Model包路径: <br>
     * modelBasePackage=cn.com.lyg.model <br>
     * 2. Model数组，逗号分隔: <br>
     * models=User,Member,Role <br>
     * 3. 输出方式，默认控制台打印， file则输出到文件: <br>
     * output=file <br>
     * 4. 是否覆盖原文件，输出方式为file时才生效。默认不覆盖原文件: <br>
     * overrid=true <br>
     ***************** 参考配置******************* <br>
     * modelBasePackage=cn.com.lyg.model <br>
     * models=User,Member,Role <br>
     * output=file <br>
     * override=true <br>
     ***************** 参考配置******************* <br>
     */
    public static void main(final String[] args) throws ClassNotFoundException {

        final String modelBasePackage = "redoc.sq.model";

        final String[] models = new String[] {"User"};

        final Output output = Output.file; // console 或 file
        boolean override = false; // 除非万不得已，默认不要覆盖本地文件

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///// 生产代码逻辑
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (output != Output.file) {
            override = false;
        }
        final String outputDir = null;
        for (final String modelClass : models) {
            final Class<?> modelClazz = Class.forName(modelBasePackage + "." + modelClass);
            final GeneratorConfiguration config = new GeneratorConfiguration(modelClazz, output.name(), outputDir, override);
            final RepositoryGenerator repositoryGenerator = new RepositoryGenerator(config);
            final ServiceGenerator serviceGenerator = new ServiceGenerator(config);
            final ServiceImplGenerator serviceImplGenerator = new ServiceImplGenerator(config);
            final DtoGenerator dtoGenerator = new DtoGenerator(config);
            final ConvertorGenerator convertorGenerator = new ConvertorGenerator(config);
            final ControllerGenerator controllerGenerator = new ControllerGenerator(config);
            repositoryGenerator.generate();
            serviceGenerator.generate();
            serviceImplGenerator.generate();
            dtoGenerator.generate();
            convertorGenerator.generate();
            controllerGenerator.generate();
        }
    }

}
