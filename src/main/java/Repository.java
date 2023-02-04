public class Repository {

    private Product[] products = new Product[0];

    public void add(Product product) {


        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];

        }
        tmp[products.length] = product;
        products = tmp;
    }

    public void removeByID(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException(removeId);
        }

        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }

}
