package abstract_factory;

 class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public CheckBox createCheckBox(String text) {
        return new CheckBoxB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }
}
