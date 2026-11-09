package fr.simplon.domedespuys.view;

public class UserView {
    public interface Id{}
    public interface Email{}
    public interface Firstname{}
    public interface Lastname{}
    public interface Phone{}
    public interface CreatedAt{}
    public interface Address{}
    public interface Purchase{}

    public interface UserListView extends Email, Firstname, Lastname{}
    public interface UserDetailView extends UserListView,
            Phone,
            CreatedAt,
            AddressView.AddressDetailView,
            PurchaseView.PurchaseListView{}

}
