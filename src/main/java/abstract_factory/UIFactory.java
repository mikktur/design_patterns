package abstract_factory;

public abstract class UIFactory {

    abstract TextField createTextField(String text);
    abstract CheckBox createCheckBox(String text);
    abstract Button createButton(String text);
}
