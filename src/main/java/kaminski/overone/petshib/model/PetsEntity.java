package kaminski.overone.petshib.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pets", schema = "public", catalog = "Pets")
public class PetsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pet_id")
    private int petId;
    @Basic
    @Column(name = "pet_species")
    private String petSpecies;
    @Basic
    @Column(name = "pet_name")
    private String petName;
    @Basic
    @Column(name = "pet_age")
    private int petAge;
    @Basic
    @Column(name = "pet_color")
    private String petColor;
    @Basic
    @Column(name = "pet_owner")
    private String petOwner;

    public PetsEntity() {
    }

    public PetsEntity(String petSpecies, String petName, int petAge, String petColor, String petOwner) {
        this.petSpecies = petSpecies;
        this.petName = petName;
        this.petAge = petAge;
        this.petColor = petColor;
        this.petOwner = petOwner;
    }

    public PetsEntity(int petId, String petSpecies, String petName, int petAge, String petColor, String petOwner) {

        this.petId = petId;
        this.petSpecies = petSpecies;
        this.petName = petName;
        this.petAge = petAge;
        this.petColor = petColor;
        this.petOwner = petOwner;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetSpecies() {
        return petSpecies;
    }

    public void setPetSpecies(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(String petOwner) {
        this.petOwner = petOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetsEntity that = (PetsEntity) o;

        if (petId != that.petId) return false;
        if (petAge != that.petAge) return false;
        if (!Objects.equals(petSpecies, that.petSpecies)) return false;
        if (!Objects.equals(petName, that.petName)) return false;
        if (!Objects.equals(petColor, that.petColor)) return false;
        if (!Objects.equals(petOwner, that.petOwner)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = petId;
        result = 31 * result + (petSpecies != null ? petSpecies.hashCode() : 0);
        result = 31 * result + (petName != null ? petName.hashCode() : 0);
        result = 31 * result + petAge;
        result = 31 * result + (petColor != null ? petColor.hashCode() : 0);
        result = 31 * result + (petOwner != null ? petOwner.hashCode() : 0);
        return result;
    }
}
