package com.example.roposo.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by himanshugupta on 10/5/16.
 */
public class StoryList {
        private String about;
        private String id;
        private String username;
        private int followers;
        private int following;
        private String image;
        private String url;
        private String handle;
        private boolean isFollowing;
        private long createdOn;
        private String description;
        private String verb;
        private String db;
        private String si;
        private String type;
        private String title;
        private boolean likeFlag;
        private int likesCount;
        private int commentCount;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         * The about
         */
        public String getAbout() {
            return about;
        }

        /**
         *
         * @param about
         * The about
         */
        public void setAbout(String about) {
            this.about = about;
        }

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The followers
         */
        public Integer getFollowers() {
            return followers;
        }

        /**
         *
         * @param followers
         * The followers
         */
        public void setFollowers(Integer followers) {
            this.followers = followers;
        }

        /**
         *
         * @return
         * The following
         */
        public Integer getFollowing() {
            return following;
        }

        /**
         *
         * @param following
         * The following
         */
        public void setFollowing(Integer following) {
            this.following = following;
        }

        /**
         *
         * @return
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The handle
         */
        public String getHandle() {
            return handle;
        }

        /**
         *
         * @param handle
         * The handle
         */
        public void setHandle(String handle) {
            this.handle = handle;
        }

        /**
         *
         * @return
         * The isFollowing
         */
        public Boolean getIsFollowing() {
            return isFollowing;
        }

        /**
         *
         * @param isFollowing
         * The is_following
         */
        public void setIsFollowing(Boolean isFollowing) {
            this.isFollowing = isFollowing;
        }

        /**
         *
         * @return
         * The createdOn
         */
        public long getCreatedOn() {
            return createdOn;
        }

        /**
         *
         * @param createdOn
         * The createdOn
         */
        public void setCreatedOn(long createdOn) {
            this.createdOn = createdOn;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The verb
         */
        public String getVerb() {
            return verb;
        }

        /**
         *
         * @param verb
         * The verb
         */
        public void setVerb(String verb) {
            this.verb = verb;
        }

        /**
         *
         * @return
         * The db
         */
        public String getDb() {
            return db;
        }

        /**
         *
         * @param db
         * The db
         */
        public void setDb(String db) {
            this.db = db;
        }

        /**
         *
         * @return
         * The si
         */
        public String getSi() {
            return si;
        }

        /**
         *
         * @param si
         * The si
         */
        public void setSi(String si) {
            this.si = si;
        }

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The likeFlag
         */
        public Boolean getLikeFlag() {
            return likeFlag;
        }

        /**
         *
         * @param likeFlag
         * The like_flag
         */
        public void setLikeFlag(Boolean likeFlag) {
            this.likeFlag = likeFlag;
        }

        /**
         *
         * @return
         * The likesCount
         */
        public Integer getLikesCount() {
            return likesCount;
        }

        /**
         *
         * @param likesCount
         * The likes_count
         */
        public void setLikesCount(Integer likesCount) {
            this.likesCount = likesCount;
        }

        /**
         *
         * @return
         * The commentCount
         */
        public Integer getCommentCount() {
            return commentCount;
        }

        /**
         *
         * @param commentCount
         * The comment_count
         */
        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }


}
