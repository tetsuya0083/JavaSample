package polymorphism;

public class ProfileService {
    public void saveProfile(ProfileRepository repository){
        repository.save();
    }
}
