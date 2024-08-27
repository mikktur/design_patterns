package abstract_factory;

class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("|______" + text + "______|");
    }
}
