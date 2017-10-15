package com.lifeonwalden.mavenplugin.ddlgenerator;

import com.lifeonwalden.codeGenerator.GenerateCodeMain;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "generate")
public class DDLGeneratorMojo extends AbstractMojo {

    @Parameter(property = "ddlgenerate.configFolder")
    private File configFolder;

    @Parameter(property = "ddlgenerate.outputFolder")
    private File outputFolder;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (null == configFolder || !configFolder.exists()) {
            RuntimeException re = new RuntimeException("Configuration folder is not exist.");
            getLog().error(re);
            throw re;
        }

        if (null == outputFolder || !outputFolder.exists()) {
            RuntimeException re = new RuntimeException("Output folder does not provided.");
            getLog().error(re);
            throw re;
        }

        for (File file : outputFolder.listFiles()) {
            rm(file);
        }

        String[] param = {configFolder.getAbsolutePath(), outputFolder.getAbsolutePath()};
        GenerateCodeMain.main(param);
    }

    private void rm(File toRemoveFile) {
        if (toRemoveFile.isFile()) {
            toRemoveFile.delete();
        } else if (toRemoveFile.isDirectory()) {
            for (File file : toRemoveFile.listFiles()) {
                rm(file);
                file.delete();
            }
        }
    }
}
