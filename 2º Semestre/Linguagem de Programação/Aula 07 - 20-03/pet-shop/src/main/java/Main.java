public class Main {
    public static void main(String[] args) {
        Pet pet01 = new Pet();

        pet01.setNome("Caramelo");
        pet01.setQtdIdasPetShop(3);
        pet01.setTotalGasto(0.0);

        Pet pet02 = new Pet("Bob", 0, 0.0);

        PetShop petShop01 = new PetShop("ShopPet", 0.0);

        System.out.println(pet01.getNome());
        System.out.println(pet01.getQtdIdasPetShop());
        System.out.println(pet01.getTotalGasto(petShop01));

        System.out.println("""
                Nome pet: %s
                Total gasto: %.2f]] 
                Quantidade idas: %d""".formatted(pet01.getNome(),
                pet01.getTotalGasto(petShop01),
                pet01.getQtdIdasPetShop()));

        petShop01.darBanho(pet01);
        petShop01.darBanho(pet01, 0.5);
    }
}
