package ro.octa.greendaosample.dao;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table DBUSER_DETAILS.
 */
public class DBUserDetails implements Parcelable {

    private Long id;
    /**
     * Not-null value.
     */
    private String nickName;
    /**
     * Not-null value.
     */
    private String firstName;
    /**
     * Not-null value.
     */
    private String lastName;
    private java.util.Date birthDate;
    private String gender;
    private String country;
    /**
     * Not-null value.
     */
    private java.util.Date registrationDate;
    private long userId;

    /**
     * Used to resolve relations
     */
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient DBUserDetailsDao myDao;

    private DBUser user;
    private Long user__resolvedKey;

    private List<DBPhoneNumber> phoneNumbers;

    public DBUserDetails() {
    }

    public DBUserDetails(Long id) {
        this.id = id;
    }

    public DBUserDetails(Long id, String nickName, String firstName, String lastName, java.util.Date birthDate, String gender, String country, java.util.Date registrationDate, long userId) {
        this.id = id;
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.country = country;
        this.registrationDate = registrationDate;
        this.userId = userId;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDBUserDetailsDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Not-null value.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Not-null value.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Not-null value.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.util.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Not-null value.
     */
    public java.util.Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setRegistrationDate(java.util.Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    public DBUser getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DBUserDao targetDao = daoSession.getDBUserDao();
            DBUser userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    public void setUser(DBUser user) {
        if (user == null) {
            throw new DaoException("To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getId();
            user__resolvedKey = userId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<DBPhoneNumber> getPhoneNumbers() {
        if (phoneNumbers == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DBPhoneNumberDao targetDao = daoSession.getDBPhoneNumberDao();
            List<DBPhoneNumber> phoneNumbersNew = targetDao._queryDBUserDetails_PhoneNumbers(id);
            synchronized (this) {
                if (phoneNumbers == null) {
                    phoneNumbers = phoneNumbersNew;
                }
            }
        }
        return phoneNumbers;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetPhoneNumbers() {
        phoneNumbers = null;
    }

    /**
     * Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context.
     */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context.
     */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context.
     */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nickName);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeLong(birthDate != null ? birthDate.getTime() : -1);
        dest.writeString(this.gender);
        dest.writeString(this.country);
        dest.writeLong(registrationDate != null ? registrationDate.getTime() : -1);
        dest.writeLong(this.userId);
        dest.writeParcelable(this.user, flags);
        dest.writeValue(this.user__resolvedKey);
        dest.writeTypedList(phoneNumbers);
    }

    private DBUserDetails(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.nickName = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        long tmpBirthDate = in.readLong();
        this.birthDate = tmpBirthDate == -1 ? null : new Date(tmpBirthDate);
        this.gender = in.readString();
        this.country = in.readString();
        long tmpRegistrationDate = in.readLong();
        this.registrationDate = tmpRegistrationDate == -1 ? null : new Date(tmpRegistrationDate);
        this.userId = in.readLong();
        this.user = in.readParcelable(DBUser.class.getClassLoader());
        this.user__resolvedKey = (Long) in.readValue(Long.class.getClassLoader());
        in.readTypedList(phoneNumbers, DBPhoneNumber.CREATOR);
    }

    public static final Creator<DBUserDetails> CREATOR = new Creator<DBUserDetails>() {
        public DBUserDetails createFromParcel(Parcel source) {
            return new DBUserDetails(source);
        }

        public DBUserDetails[] newArray(int size) {
            return new DBUserDetails[size];
        }
    };
}
