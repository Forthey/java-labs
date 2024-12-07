public enum NumberEnum {
    ONE(1) {
        @Override
        public String usefulInfo() {
            return "This is one";
        }
    },
    TWO(2) {
        public String usefulInfo() {
            return "This is two";
        }
    },
    THIRTY(30) {
        public String usefulInfo() {
            return "This is thirty (best number)";
        }
    };

    private final int number;

    NumberEnum(int number) {
        this.number = number;
    }

    public abstract String usefulInfo();

    public int getNumber() {
        return number;
    }
}
