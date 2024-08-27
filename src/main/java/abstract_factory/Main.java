package abstract_factory;

public class Main
{
    public static void main(String[] args)
    {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory() {
        };

        TextField textFieldA = factoryA.createTextField("Hello");
        CheckBox checkBoxA = factoryA.createCheckBox("Yes");
        Button buttonA = factoryA.createButton("Click me");

        TextField textFieldB = factoryB.createTextField("World");
        CheckBox checkBoxB = factoryB.createCheckBox("No");
        Button buttonB = factoryB.createButton("Don't click me");

        System.out.println("TextFields: ");
        textFieldA.display();
        textFieldB.display();

        System.out.println("CheckBoxes: ");
        checkBoxA.display();
        checkBoxB.display();

        System.out.println("Buttons: ");
        buttonA.display();
        buttonB.display();
    }
}
