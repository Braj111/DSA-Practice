class ProductOfNumbers {
    private List<Integer> prefixProducts;  
    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }
    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }
    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (n <= k) {
            return 0;
        } else {
            return prefixProducts.get(n - 1) / prefixProducts.get(n - k - 1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */