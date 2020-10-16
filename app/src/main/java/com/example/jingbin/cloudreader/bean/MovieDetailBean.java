package com.example.jingbin.cloudreader.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.jingbin.cloudreader.BR;
import com.example.jingbin.cloudreader.bean.moviechild.ImagesBean;
import com.example.jingbin.cloudreader.bean.moviechild.PersonBean;
import com.example.jingbin.cloudreader.bean.moviechild.RatingBean;

import java.util.List;

/**
 * Created by jingbin on 2016/12/9.
 */

public class MovieDetailBean extends BaseObservable {


    /**
     * rating : {"max":10,"average":6.9,"stars":"35","min":0}
     * reviews_count : 2440
     * wish_count : 22882
     * douban_site :
     * year : 2016
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2378133884.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2378133884.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2378133884.jpg"}
     * （更多信息）alt : https://movie.douban.com/subject/26630781/
     * id : 26630781
     * mobile_url : https://movie.douban.com/subject/26630781/mobile
     * title : 我不是潘金莲
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/26630781
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/26630781/cinema/
     * episodes_count : null
     * countries : ["中国大陆"]
     * genres : ["剧情","喜剧"]
     * collect_count : 73047
     * casts : [{"alt":"https://movie.douban.com/celebrity/1050059/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1691.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1691.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1691.jpg"},"name":"范冰冰","id":"1050059"},{"alt":"https://movie.douban.com/celebrity/1274274/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/39703.jpg","large":"https://img3.doubanio.com/img/celebrity/large/39703.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/39703.jpg"},"name":"郭涛","id":"1274274"},{"alt":"https://movie.douban.com/celebrity/1324043/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/58870.jpg","large":"https://img3.doubanio.com/img/celebrity/large/58870.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/58870.jpg"},"name":"大鹏","id":"1324043"},{"alt":"https://movie.douban.com/celebrity/1275044/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/28615.jpg","large":"https://img3.doubanio.com/img/celebrity/large/28615.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/28615.jpg"},"name":"张嘉译","id":"1275044"}]
     * current_season : null
     * original_title : 我不是潘金莲
     * summary : 一个普通的农村妇女李雪莲（范冰冰 饰），为了纠正一句话，与上上下下、方方面面打了十年交道。打交道的过程中，她没想到一件事变成了另一件事，接着变成了第三件事。十年过去，她没有把这句话纠正过来，但她饱尝了世间的人情冷暖，悟明白了另外一个道理。李雪莲要纠正的这句话是她前夫说的。她前夫说：你是李雪莲吗？我咋觉得你是潘金莲呢？李雪莲要告诉大家的是：我不是潘金莲。©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1274255/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/45667.jpg","large":"https://img1.doubanio.com/img/celebrity/large/45667.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/45667.jpg"},"name":"冯小刚","id":"1274255"}]
     * comments_count : 36102
     * ratings_count : 68772
     * aka : ["我是李雪莲","我叫李雪莲","I Am Not Madame Bovary"]
     */

    private RatingBean rating;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String title;
    private String summary;
    private String subtype;
    private List<String> countries;
    private List<String> genres;
    private List<PersonBean> casts;
    private List<PersonBean> directors;
    private List<String> aka;

    @Bindable
    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
        notifyPropertyChanged(BR.rating);
    }

    @Bindable
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }

    @Bindable
    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
        notifyPropertyChanged(BR.images);
    }

    @Bindable
    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
        notifyPropertyChanged(BR.alt);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
        notifyPropertyChanged(BR.summary);
    }

    @Bindable
    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
        notifyPropertyChanged(BR.subtype);
    }

    @Bindable
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
        notifyPropertyChanged(BR.countries);
    }

    @Bindable
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
        notifyPropertyChanged(BR.genres);
    }

    @Bindable
    public List<PersonBean> getCasts() {
        return casts;
    }

    public void setCasts(List<PersonBean> casts) {
        this.casts = casts;
        notifyPropertyChanged(BR.casts);
    }

    @Bindable
    public List<PersonBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<PersonBean> directors) {
        this.directors = directors;
        notifyPropertyChanged(BR.directors);
    }

    @Bindable
    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
        notifyPropertyChanged(BR.aka);
    }
}
