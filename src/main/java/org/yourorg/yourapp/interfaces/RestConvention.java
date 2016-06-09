package org.yourorg.yourapp.interfaces;

public interface RestConvention {
    public String index();  // GET    /resource
    public String _new();   // GET    /resource/new
    public String create(); // POST   /resource
    public String show();   // GET    /resource/{id}
    public String edit();   // GET    /resource/{id}/edit
    public String update(); // PUT    /resource/{id}
    public String delete(); // DELETE /resource/{id}
}
