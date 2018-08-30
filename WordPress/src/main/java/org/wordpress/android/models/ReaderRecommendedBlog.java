package org.wordpress.android.models;

import org.json.JSONObject;
import org.wordpress.android.util.JSONUtils;
import org.wordpress.android.util.StringUtils;

public class ReaderRecommendedBlog {
    public long blogId;
    public long followRecoId;
    public int score;

    private String mTitle;
    private String mBlogUrl;
    private String mImageUrl;
    private String mReason;

    /*
     * populated by response from get/read/recommendations/mine/
     */
    public static ReaderRecommendedBlog fromJson(JSONObject json) {
        if (json == null) {
            return null;
        }

        ReaderRecommendedBlog blog = new ReaderRecommendedBlog();

        blog.blogId = json.optLong("blog_id");
        blog.followRecoId = json.optLong("follow_reco_id");
        blog.score = json.optInt("score");

        blog.setTitle(JSONUtils.getString(json, "title"));
        blog.setImageUrl(JSONUtils.getString(json, "image"));
        blog.setReason(JSONUtils.getStringDecoded(json, "reason"));

        // the "url" field points to an API endpoint, "blog_domain" contains the actual url
        blog.setBlogUrl(JSONUtils.getString(json, "blog_domain"));

        return blog;
    }

    public String getTitle() {
        return StringUtils.notNullStr(mTitle);
    }

    public void setTitle(String title) {
        mTitle = StringUtils.notNullStr(title);
    }

    public String getReason() {
        return StringUtils.notNullStr(mReason);
    }

    public void setReason(String reason) {
        mReason = StringUtils.notNullStr(reason);
    }

    public String getBlogUrl() {
        return StringUtils.notNullStr(mBlogUrl);
    }

    public void setBlogUrl(String blogUrl) {
        mBlogUrl = StringUtils.notNullStr(blogUrl);
    }

    public String getImageUrl() {
        return StringUtils.notNullStr(mImageUrl);
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = StringUtils.notNullStr(imageUrl);
    }

    protected boolean isSameAs(ReaderRecommendedBlog blog) {
        if (blog == null) {
            return false;
        }
        return (blog.blogId == this.blogId
                && blog.score == this.score
                && blog.followRecoId == this.followRecoId);
    }
}
