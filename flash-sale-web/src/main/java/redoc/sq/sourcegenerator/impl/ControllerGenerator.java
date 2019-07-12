package redoc.sq.sourcegenerator.impl;


import redoc.sq.sourcegenerator.AbstractGenerator;
import redoc.sq.sourcegenerator.ContentsFilter;
import redoc.sq.sourcegenerator.utils.GeneratorConfiguration;

import java.util.HashMap;
import java.util.Map;

public class ControllerGenerator extends AbstractGenerator {

    // 模板路径
    private static final String templatePath = "/codetemplate/Controller.template";

    private ContentsFilter filter;

    private final String templateContents;

    public ControllerGenerator(final GeneratorConfiguration config) {
        super(config, "controller");
        this.initFilter();
        this.templateContents = this.getFileString(ControllerGenerator.templatePath);
    }

    @Override
    public void generate() {
        final String value = this.filter.filter(this.templateContents);
        this.output(value);
    }

    private void initFilter() {
        final Map<String, String> filterMap = new HashMap<String, String>();
        filterMap.put("@Package@", this.getPackage("controller"));
        filterMap.put("@ModelPath@", this.getModelPath());
        filterMap.put("@Model@", this.getModelName());
        filterMap.put("@model@", this.getModelNameWithHeadLow());
        filterMap.put("@DTOPath@", this.getClassPath("dto"));
        filterMap.put("@ConvertorPath@", this.getClassPath("convertor"));
        filterMap.put("@ServicePath@", this.getClassPath("service"));
        filterMap.put("@RepositoryPath@", this.getClassPath("repository"));
        this.filter = new ReplaceFilter(filterMap);
    }
}
