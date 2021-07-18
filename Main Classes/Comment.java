/**
 * This is a comment class to let each user comment about their shopping experiences
 * @version 18 July, 2021
 * @author Parsa Keihan
 */
public class Comment {

    //Variables
    String text;
    int like;
    int dislike;
    int servicePoint;
    int freshnessPoint;
    MarekUser marketUser;
    CostumerUser costumerUser;

    //Constructor
    /**
     * To make a single comment with all provided properties
     * @param text
     * @param like
     * @param dislike
     * @param servicePoint
     * @param freshnessPoint
     * @param marekUser
     */
    public Comment(String text, int like, int dislike, int servicePoint, int freshnessPoint, MarekUser marketUser, CostumerUser costumerUser){
        this.text = text;
        this.like = like;
        this.dislike = dislike;
        this.servicePoint = servicePoint;
        this.freshnessPoint = freshnessPoint;
        this.marketUser = marketUser;
        this.costumerUser = costumerUser;
        this.name = null;
    }

    //methods
    /**
     * gets the text of a single comment
     * @return the text
     */
    public String getComment(){
        return text;
    }

    /**
     * adds a text to the body of a single comment
     * @param text
     */
    public void setComment(String text){
        this.text = text;
    }

    /**
     * gets the service point of a market
     * @return the point
     */
    public int getServicePoint() {
        return servicePoint;
    }

    /**
     * gets the freshness point of a market
     * @return the point
     */
    public int getFreshnessPoint() {
        return freshnessPoint;
    }

    /**
     * gets the name of the costumer who made the comment
     * @return the name
     */
    public String getName(){
        return costumerUser.getName();
    }

    /**
     * gets the like numbers
     * @return the like numbers
     */
    public int getLike() {
        return like;
    }

    /**
     * gets the dislike numbers
     * @return the dislike numbers
     */
    public int getDislike() {
        return dislike;
    }

    /**
     * increases the like of the specified comment
     */
    public void addLikeCount(){
        like++;
    }

    /**
     * increases the dislike of the specified comment
     */
    public void addDislikeCount(){
        dislike++;
    }

    /**
     * calculates the average point of a market
     * @return
     */
    public double calculateAverages(){
        return (getFreshnessPoint() + getServicePoint()) / 2;
    }

    public void display(){
        System.out.println(getComment() + getName() + calculateAverages() + getLike() + getDislike(););
    }
}
