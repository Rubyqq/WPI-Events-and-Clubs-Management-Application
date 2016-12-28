package wpiv10.myapplication.constant;

/**
 * SQL commands
 * Including select/delete/update/insert
 */

public abstract class SQLCommand

{
    //query all students
    public static String QUERY_1 = "select student_id from student where student_id=?";
    public static String QUERY_Test = "select * from student";
    public static String FOR_SCROLLVIEW = "select student_id,event_id,registration_status from student_event_registration";
    public static String QUERY_2 = "select * from student where student_id=?";
    public static String QUERY_3 = "select * from student where student_id=? and student_password=?";
    public static String JOIN_IN = "insert into student(student_id,student_fname,student_lname,student_phonenum, student_email, student_gender, student_password, department_id) values (?,?,?,?,?,?,?,?)";
    public static String CHECKOUT_LIST = "select student_id as _id, student_fname, student_lname from student Where student_id = 3";
    public static String CHECKOUT_LIST_Club = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, club, club_event_hold where event.event_id = club_event_hold.event_id and club_event_hold.club_id = club.club_id and club.club_name = 'Chess club'";
    public static String CHECKOUT_LIST_Club_one = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, club, club_event_hold where event.event_id = club_event_hold.event_id and club_event_hold.club_id = club.club_id and club.club_name = 'Ballroom dance club'";
    public static String CHECKOUT_LIST_Club_two = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, club, club_event_hold where event.event_id = club_event_hold.event_id and club_event_hold.club_id = club.club_id and club.club_name = 'Graduate student Government'";
    public static String CHECKOUT_LIST_Club_three = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, club, club_event_hold where event.event_id = club_event_hold.event_id and club_event_hold.club_id = club.club_id and club.club_name = 'South Asian Student Association'";
    public static String CHECKOUT_LIST_Type_Club = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, eventtype, event_eventtype where event.event_id = event_eventtype.event_id and event_eventtype.eventtype_id = eventtype.eventtpye_id and eventtype.eventtype_name = 'Sport'";
    public static String CHECKOUT_LIST_Type_Club_one = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, eventtype, event_eventtype where event.event_id = event_eventtype.event_id and event_eventtype.eventtype_id = eventtype.eventtpye_id and eventtype.eventtype_name = 'Social'";
    public static String CHECKOUT_LIST_Type_Club_two = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, eventtype, event_eventtype where event.event_id = event_eventtype.event_id and event_eventtype.eventtype_id = eventtype.eventtpye_id and eventtype.eventtype_name = 'Culture'";
    public static String CHECKOUT_LIST_Type_Club_three = "select event.event_id as _id, event_name, event_date, event_time, event_location from event, eventtype, event_eventtype where event.event_id = event_eventtype.event_id and event_eventtype.eventtype_id = eventtype.eventtpye_id and eventtype.eventtype_name = 'Art'";
    public static String CHECKOUT_EVENT = "select event_date from event where event_date=?";
    public static String QUERY_6 = "select event.event_id as _id,event_name,event_date,event_time, event_location, event_desc, event_attendees from event, eventtype, event_eventtype where event.event_id = event_eventtype.event_id and event_eventtype.eventtype_id = eventtype.eventtpye_id and event.event_location like ? and eventtype.eventtype_name like ?";
    public static String CHOOSE_DATE_EVENT = "select event.event_id as _id, event_name, event_date, event_time, event_location, event_desc,event_attendees from event where event_date= '2016-11-05'";
    public static String CHOOSE_DATE_EVENT_one = "select event.event_id as _id, event_name, event_date, event_time, event_location, event_desc,event_attendees from event where event_date= '2016-11-04'";
    public static String CHOOSE_DATE_EVENT_two = "select event.event_id as _id, event_name, event_date, event_time, event_location, event_desc,event_attendees from event where event_date= '2016-11-06'";
    public static String CHOOSE_DATE_EVENT_three = "select event.event_id as _id, event_name, event_date, event_time, event_location, event_desc,event_attendees from event where event_date= '2016-12-09'";
    public static String CHOOSE_DATE_EVENT_four = "select event.event_id as _id, event_name, event_date, event_time, event_location, event_desc,event_attendees from event where event_date= '2016-12-06'";
    public static String CHOOSE_DATE_EVENT_five = "select event.event_id as _id, event_name, event_date, event_time, event_location, event_desc,event_attendees from event where event_date= '2016-12-13'";
    public static String SET_EVENT = "update event set event_attendees=? where event_id=?";
    public static String QUERY_7 = "select deparment_id from department where department_name=?";
    public static String QUERY_8 = "select student_id from student where student_id=?";
    public static String QUERY_9 = "select event_attendees from event where event_name=?";
    public static String CHECK_EVENT = "update student_event_registration set registration_status=? where student_id=? and event_id=?";
    public static String REGISTER_EVENT = "insert into student_event_registration(student_id,event_id,registration_status) values(?,?,?)";
    public static String CHECKOUT_SUMMARY = "select strftime('%m',event_date) as month,count(*) as total from event where strftime('%Y',event_date)='2016' group by month order by total desc";
    public static String QUERY_10 = "select event.event_id as _id,event_name,event_date,event_time, event_location, event_desc, event_attendees from event where event.event_name = ?";
    public static String QUERY_11 = "select event.event_id as _id,event_name,event_date,event_time, event_location, event_desc, event_attendees from event";
    public static String QUERY_12 = "select club_id as _id,club_name from club order by club_name desc";
    public static String QUERY_13 = "select club_id as _id,club_name from club where club_name = ? order by club_name desc";
    public static String QUERY_14 = "select club_id as _id,club_name from club order by club_name asc";
    public static String QUERY_15 = "select club_id as _id,club_name from club where club_name = ? order by club_name asc";
    public static String QUERY_16 = "select club_id as _id,club_name, club_chapter, club_email from club, clubtype where club.clubtype_id = clubtype.clubtype_id and clubtype_desc = 'Sport'";
    public static String QUERY_17 = "select club_id as _id,club_name, club_chapter, club_email from club, clubtype where club.clubtype_id = clubtype.clubtype_id and clubtype_desc = 'Social'";
    public static String QUERY_18 = "select club_id as _id,club_name, club_chapter, club_email from club, clubtype where club.clubtype_id = clubtype.clubtype_id and clubtype_desc = 'Student Association'";
    public static String QUERY_19 = "select club_id as _id,club_name, club_chapter, club_email from club, clubtype where club.clubtype_id = clubtype.clubtype_id and clubtype_desc = 'Art'";
}


