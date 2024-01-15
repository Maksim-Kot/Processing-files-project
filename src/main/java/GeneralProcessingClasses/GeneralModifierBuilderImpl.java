package GeneralProcessingClasses;

import AdditionalClasses.FileModification;

public class GeneralModifierBuilderImpl implements GeneralModifierBuilder {

    GeneralModifier mod = new GeneralModifier();

    @Override
    public GeneralModifierBuilder setNameOfArchive(String nameOfArchive) {
        mod.nameOfArchive = nameOfArchive;
        return this;
    }

    @Override
    public GeneralModifierBuilder setDirectoryName(String directoryName) {
        mod.directoryName = directoryName;
        return this;
    }

    @Override
    public GeneralModifierBuilder setKey(String key) {
        mod.key = key;
        return this;
    }

    @Override
    public GeneralModifierBuilder setFileModification(FileModification fileModification) {
        mod.fileModification = fileModification;
        return this;
    }

    @Override
    public GeneralModifier build() {
        return mod;
    }
}
