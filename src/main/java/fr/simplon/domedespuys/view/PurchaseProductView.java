package fr.simplon.domedespuys.view;

public class PurchaseProductView {
    public interface Id{}
    public interface Quantity{}
    public interface Price{}
    public interface Purchases{}
    public interface Products{}

    public interface PurchaseProductListView extends Quantity, Price{}
    public interface PurchaseProductDetailView extends PurchaseProductListView,
            Purchases,
            PurchaseView.PurchaseListView,
            Products,
            ProductView.ProductListView{}
}
