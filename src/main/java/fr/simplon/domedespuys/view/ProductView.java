package fr.simplon.domedespuys.view;

public class ProductView {
    public interface Id{}
    public interface Label{}
    public interface Description{}
    public interface Slug {}
    public interface Price {}
    public interface CreatedAt {}
    public interface Brand {}
    public interface Images {}
    public interface MainImage {}

    public interface ProductListView extends Label, Price, Slug, MainImage{}
    public interface ProductDetailView extends ProductListView, Description, Brand, Images {}
}
