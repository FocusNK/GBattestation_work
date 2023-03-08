package Model;

public class PetCreator extends Creator {

    @Override
    protected Pet createNewPet (PetType type) {

        switch (type) {
            case Cats:
                return new Cats();
            case Dogs:
                return new Dogs();
            case Hamsters:
                return new Hamsters();
        }
        return null;
    }
}
