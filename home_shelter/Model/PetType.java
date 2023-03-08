package Model;

public enum PetType {
    
    Cats,
    Dogs,
    Hamsters;

    public static PetType getType (int typeId){
        switch (typeId){
            case 1:
                return PetType.Cats;
            case 2:
                return PetType.Dogs;
            case 3:
                return PetType.Hamsters;
            default:
                return null;
        }
    }
}
