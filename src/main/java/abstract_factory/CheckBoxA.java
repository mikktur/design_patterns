package abstract_factory;

class CheckBoxA extends CheckBox {
    public CheckBoxA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[" + text + "]");
    }

}
