package com.example.recruiter

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.datastore : DataStore<Preferences> by preferencesDataStore("RECRUITER_PROFILE_INFO")

data class RecruiterProfileInfo(val context: Context){



    companion object {

        val userType = stringPreferencesKey("USER_TYPE")
        val userId = stringPreferencesKey("USER_ID")
        val userCom = stringPreferencesKey("user_com")
        val userFName = stringPreferencesKey("USER_F_NAME")
        val userLName = stringPreferencesKey("USER_L_NAME")
        val userPhoneNumber = stringPreferencesKey("PHONE_NUMBER")
        val userEmailId = stringPreferencesKey("EMAIL_ID")
        val userProfileImg = stringPreferencesKey("PROFILE_IMG")
        val userProfileBannerImg = stringPreferencesKey("PROFILE_BANNER_IMG")
        val userTagLine = stringPreferencesKey("TAG_LINE")
        val userCurrentCompany = stringPreferencesKey("USER_CURRENT_COMPANY")

        val userJobTitle = stringPreferencesKey("JOB_TITLE")
        val userSalary = stringPreferencesKey("SALARY")
        val userJobLocation = stringPreferencesKey("JOB_LOCATION")
        val userBio  = stringPreferencesKey("BIO")
        val userDesignation = stringPreferencesKey("DESIGNATION")
        val userWorkingMode = stringPreferencesKey("WORKING_MODE")
    }

    suspend fun storeAboutData(
        jobTitle:String,
        salary:String,
        jobLocation:String,
        bio:String,
        designation:String,
        workingMode:String
    ){
        context.datastore.edit {
            it[userJobTitle] = jobTitle
            it[userSalary] = salary
            it[userJobLocation] = jobLocation
            it[userBio] = bio
            it[userDesignation] = designation
            it[userWorkingMode] = workingMode
        }
    }

    suspend fun storeUserType(
        type:String,
        id:String
    ){
        context.datastore.edit {
            it[userType] = type
            it[userId]  = id
        }
    }

    suspend fun storeBasicProfileData(
        fName:String,
        lName:String,
        phoneNumber:String,
        emailId:String,
        tageLine:String,
        currentCompany:String
    ){

        context.datastore.edit {
            it[userFName] = fName
            it[userLName] = lName
            it[userPhoneNumber] = phoneNumber
            it[userEmailId] = emailId
            it[userTagLine] = tageLine
            it[userCurrentCompany] = currentCompany
        }
    }
    suspend fun storeProfileImg(
        profileImg:String
    ){
        context.datastore.edit {
            it[userProfileImg] = profileImg
        }
    }

    suspend fun storeProfileBannerImg(
        profileBannerImg:String
    ){
        context.datastore.edit {
            it[userProfileBannerImg] = profileBannerImg
        }
    }

    fun getUserType() = context.datastore.data.map{
        it[userType]?:""
    }
    fun getUserId() = context.datastore.data.map{
        it[userId]?:""
    }
    fun getUserFName() = context.datastore.data.map {
        it[userFName]?:""
    }
    fun getUserLName() = context.datastore.data.map {
        it[userLName]?:""
    }
    fun getUserPhoneNumber() = context.datastore.data.map {
        it[userPhoneNumber]?:""
    }
    fun getUserEmailId() = context.datastore.data.map {
        it[userEmailId]?:""
    }
    fun getUserProfileImg() = context.datastore.data.map {
        it[userProfileImg]?:""
    }
    fun getUserProfileBannerImg() = context.datastore.data.map {
        it[userProfileBannerImg]?:""
    }
    fun getUserTageLine() = context.datastore.data.map {
        it[userTagLine]?:""
    }
    fun getUserCurrentCompany() = context.datastore.data.map {
        it[userCurrentCompany]?:""
    }
    fun getUserJobTitle() = context.datastore.data.map {
        it[userJobTitle]?:""
    }
    fun getUserSalary() = context.datastore.data.map {
        it[userSalary]?:""
    }
    fun getUserJobLocation() = context.datastore.data.map {
        it[userJobLocation]?:""
    }
    fun getUserBio() = context.datastore.data.map {
        it[userBio]?:""
    }
    fun getUserDesignation() = context.datastore.data.map {
        it[userDesignation]?:""
    }
    fun getUserWorkingMode() = context.datastore.data.map {
        it[userWorkingMode]?:""
    }
}
