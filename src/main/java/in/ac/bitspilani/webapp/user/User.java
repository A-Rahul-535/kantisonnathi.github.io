package in.ac.bitspilani.webapp.user;

import com.twilio.type.PhoneNumber;
import in.ac.bitspilani.webapp.category.Category;
import in.ac.bitspilani.webapp.model.NamedEntity;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple JavaBean domain object representing an user.
 *
 * @author Kanti Sonnathi
 */

@Entity
public class User extends NamedEntity {


    public boolean userNew = true;

    @Column(name = "email")
    @NotEmpty
    private String email;

    public boolean isUserComplete() {
        return isUserComplete;
    }

    public void setUserComplete(boolean userComplete) {
        isUserComplete = userComplete;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    /*This variable returns true if and only if all the mandatory attributes in this object are present. If any are\
        absent, then a page asking for additional data should be displayed.
        TODO: write code to make isUserComplete work the way it's supposed to
         */
    public boolean isUserComplete = false;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "profession")
    private String profession;
    @Column(name="password")
    private String password;

    //The following two variables are public because their only functionality lies outside the class

    @Column(name = "email_verified")
    public boolean emailVerified;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "phone_verified")
    public boolean phoneVerified;

    public Set<Category> getCategories() {
        return categories;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Category> categories;

    public Category getCategory(String name) {
        return getCategory(name, false);
    }

    public Category getCategory(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Category pet : getCategoriesInternal()) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

    protected Set<Category> getCategoriesInternal() {
        if (this.categories == null) {
            this.categories = new HashSet<>();
        }
        return this.categories;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {

        this.email = email.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void addCategory(Category category) {
        categories.add(category);
        category.setUser(this);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId()).append("new", this.isNew())
                .append("name", this.getName()).append("phoneNumber",this.getPhoneNumber()).toString();
    }
}

