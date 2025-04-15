package Encapsulation;

class Car { // Encapsulation verilənləri (private) gizlədərək yalnız metodlar (public) vasitəsilə onlara giriş imkanı yaradır.
    private String model;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}