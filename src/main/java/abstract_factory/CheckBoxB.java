package abstract_factory;

 class CheckBoxB extends CheckBox {
    public CheckBoxB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("(" + text + ")");
    }
}
