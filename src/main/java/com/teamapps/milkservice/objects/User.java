package com.teamapps.milkservice.objects;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Mihai Alexandru
 * @date 22.12.2018
 */
public class User {

    private Integer id;

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private byte[] picture;

    private String roles;

    private User() {
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Arrays.equals(picture, user.picture) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static final class UserBuilder {
        private Integer id;
        private String login;
        private String firstName;
        private String lastName;
        private String email;
        private byte[] picture;
        private String roles;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPicture(byte[] picture) {
            this.picture = picture;
            return this;
        }

        public UserBuilder withRoles(String roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            User user = new User();
            user.email = this.email;
            user.firstName = this.firstName;
            user.roles = this.roles;
            user.id = this.id;
            user.login = this.login;
            user.lastName = this.lastName;
            user.picture = this.picture;
            return user;
        }
    }
}
