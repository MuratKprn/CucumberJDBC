package Manage;

public class QueryManage {

    private String query01 = "SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount BETWEEN 100 and 500";
    private String query02 = "SELECT name FROM u168183796_qaloantec.cron_schedules LIMIT 2";
    private String query03 = "SELECT firstname, lastname FROM users WHERE country_code NOT lIKE 'TR' AND id=11";
    private String query04 = "SELECT user_id, GROUP_CONCAT(browser, ' - ', os ) AS browser_os FROM user_logins GROUP BY user_id";

    private String update01 = "UPDATE users SET mobile= 33333333 WHERE username LIKE '%e_'";

    private String prepared01 = "UPDATE users SET mobile= ? WHERE username LIKE ?";
    private String prepared02 = "INSERT INTO admin_password_resets (id,email,token,status) VALUES (?,?,?,?)";


    public String getQuery01() {
        return query01;
    }

    public String getQuery02() {
        return query02;
    }

    public String getQuery03() {
        return query03;
    }

    public String getQuery04() {
        return query04;
    }

    public String getUpdate01() {
        return update01;
    }

    public String getPrepared01() {
        return prepared01;
    }

    public String getPrepared02() {
        return prepared02;
    }

}
