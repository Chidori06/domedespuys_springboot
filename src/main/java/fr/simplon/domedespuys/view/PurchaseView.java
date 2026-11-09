package fr.simplon.domedespuys.view;

public class PurchaseView {
    public interface Id{}
    public interface Number{}
    public interface Status{}
    public interface CreatedAt{}
    public interface User{}
    public interface Address{}
    public interface OrderProduct{}

    public interface PurchaseListView extends Number, Status, CreatedAt {}
    public interface PurchaseDetailView extends PurchaseListView,
            User,
            UserView.UserListView,
            Address,
            AddressView.AddressListView,
            OrderProduct,
            PurchaseProductView.PurchaseProductListView {}
}
