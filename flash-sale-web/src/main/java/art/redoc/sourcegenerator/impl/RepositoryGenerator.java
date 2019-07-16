package art.redoc.sourcegenerator.impl;

import art.redoc.sourcegenerator.AbstractGenerator;
import art.redoc.sourcegenerator.ContentsFilter;
import art.redoc.sourcegenerator.utils.GeneratorConfiguration;

import java.util.HashMap;
import java.util.Map;

public class RepositoryGenerator extends AbstractGenerator {

    // 模板路径
    private static final String templatePath = "/codetemplate/Repository.template";

    private ContentsFilter filter;

    private final String templateContents;

    public RepositoryGenerator(final GeneratorConfiguration config) {
        super(config, "repository");
        this.initFilter();
        this.templateContents = this.getFileString(RepositoryGenerator.templatePath);
    }

    @Override
    public void generate() {
        final String value = this.filter.filter(this.templateContents);
        this.output(value);
    }

    private void initFilter() {
        final Map<String, String> filterMap = new HashMap<String, String>();
        filterMap.put("@Package@", this.getPackage("repository"));
        filterMap.put("@ModelPath@", this.getModelPath());
        filterMap.put("@Model@", this.getModelName());
        this.filter = new ReplaceFilter(filterMap);
    }
}
