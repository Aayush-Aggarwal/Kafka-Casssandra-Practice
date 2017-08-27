package edu.knoldus

import twitter4j.{Query, TwitterFactory}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.collection.JavaConverters._


/**
  * Created by knoldus on 8/22/17.
  */
class TwitterKafkaDemo {

  private val twitter = TwitterFactory.getSingleton


  def hashTagByUser(userNmae:String):Future[List[String]]={
    Future{
      twitter.getUserTimeline(userNmae).asScala.toList.flatMap{
        result =>result.getHashtagEntities.toList.map(_.getText)
      }
    }
  }


  def tweetsForHashTag(hashTag: String): Future[List[String]] = {

    Future {
      val query = new Query(hashTag)
      val result = twitter.search(query)

      for (status <- result.getTweets.asScala.toList)
        yield "@" + status.getUser.getScreenName + ":" + status.getText + "\n"

    }
  }
}
