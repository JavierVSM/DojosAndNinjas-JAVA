package LanguageRepository;

public interface NinjaDojoRepository extends CrudRepository {
	
	@Repository 
	public interface LanguageRepository <Language, Long >{
		List <Language> findAll();
		Optional <Language> findByIdentifier(long id);
		Language save (Language language);
	}

}
