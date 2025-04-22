import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 会员类，用于表示超市的会员信息
class Member {
    // 会员ID
    private String memberId;
    // 密码
    private String password;
    // 积分
    private int points;
    // 加入时间
    private Date joinDate;

    // 构造函数，用于创建会员对象
    public Member(String memberId, String password) {
        this.memberId  = memberId;
        this.password  = password;
        this.points  = 0;
        this.joinDate  = new Date();
    }

    // 获取会员ID
    public String getMemberId() {
        return memberId;
    }

    // 获取会员密码
    public String getPassword() {
        return password;
    }

    // 获取会员积分
    public int getPoints() {
        return points;
    }

    // 获取会员加入时间
    public Date getJoinDate() {
        return joinDate;
    }

    // 增加会员积分
    public void addPoints(int points) {
        this.points  += points;
    }

    // 积分兑换方法，若积分足够则扣除相应积分并返回true，否则返回false
    public boolean redeemPoints(int points) {
        if (this.points  >= points) {
            this.points  -= points;
            return true;
        }
        return false;
    }

    // 修改会员密码
    public void changePassword(String newPassword) {
        this.password  = newPassword;
    }
}

// 超市会员管理系统类，包含系统的主要逻辑
public class SupermarketMemberSystem {
    // 用于从控制台读取用户输入
    private static Scanner scanner = new Scanner(System.in);
    // 存储会员信息的映射，键为会员ID，值为会员对象
    private static Map<String, Member> memberMap = new HashMap<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println(" 欢迎进入超市会员管理系统");
            System.out.println(" 请选择操作：");
            System.out.println("1. 开卡");
            System.out.println("2. 积分累计");
            System.out.println("3. 积分兑换");
            System.out.println("4. 查询剩余积分");
            System.out.println("5. 修改密码");
            System.out.println("6. 退出");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    openCard();
                    break;
                case 2:
                    accumulatePoints();
                    break;
                case 3:
                    redeemPoints();
                    break;
                case 4:
                    checkPoints();
                    break;
                case 5:
                    changePassword();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("  无效的选择，请重试。");
            }
        }
        scanner.close();
    }

    // 开卡方法，创建新的会员信息
    private static void openCard() {
        System.out.println("  请输入会员ID：");
        String memberId = scanner.next();
        System.out.println("  请输入初始密码：");
        String password = scanner.next();

        if (password.length()< 6) {
            System.out.println("  密码长度至少为6位，请重试。");
            return;
        }
        // 查询map中是否存在ID·
        if (memberMap.containsKey(memberId))  {
            System.out.println("  该会员ID已存在，请重试。");
        } else {
            Member member = new Member(memberId, password);
            memberMap.put(memberId,  member);
            System.out.println("  开卡成功！开卡时间：" + member.getJoinDate());
        }
    }

    // 积分累计方法，为指定会员增加积分
    private static void accumulatePoints() {
        System.out.println("  请输入会员ID：");
        String memberId = scanner.next();
        // 请输入您这次消费的金额 1元积1分
        System.out.println("  请输入要累计的积分：");
        int points = scanner.nextInt();

        if (memberMap.containsKey(memberId))  {
            Member member = memberMap.get(memberId);
            member.addPoints(points);
            System.out.println("  积分累计成功，当前积分为：" + member.getPoints());
        } else {
            System.out.println("  该会员ID不存在，请重试。");
        }
    }

    // 积分兑换方法，为指定会员进行积分兑换
    private static void redeemPoints() {
        System.out.println("  请输入会员ID：");
        String memberId = scanner.next();
        System.out.println("  请输入要兑换的积分：");
        int points = scanner.nextInt();

        if (memberMap.containsKey(memberId))  {
            Member member = memberMap.get(memberId);
            if (member.redeemPoints(points))  {
                System.out.println("  积分兑换成功，当前积分为：" + member.getPoints());
            } else {
                System.out.println("  积分不足，无法兑换。");
            }
        } else {
            System.out.println("  该会员ID不存在，请重试。");
        }
    }

    // 查询剩余积分方法，查询指定会员的剩余积分
    private static void checkPoints() {
        System.out.println("  请输入会员ID：");
        String memberId = scanner.next();

        if (memberMap.containsKey(memberId))  {
            Member member = memberMap.get(memberId);
            System.out.println("  当前积分为：" + member.getPoints());
        } else {
            System.out.println("  该会员ID不存在，请重试。");
        }
    }

    // 修改密码方法，为指定会员修改密码
    private static void changePassword() {
        System.out.println("  请输入会员ID：");
        String memberId = scanner.next();
        System.out.println("  请输入当前密码：");
        String currentPassword = scanner.next();

        if (memberMap.containsKey(memberId))  {
            Member member = memberMap.get(memberId);
            if (member.getPassword().equals(currentPassword))  {
                System.out.println("  请输入新密码：");
                String newPassword = scanner.next();

                // 校验新密码长度，这里假设密码长度至少为6位
                if (newPassword.length()  < 6) {
                    System.out.println("  密码长度至少为6位，请重试。");
                    return;
                }

                member.changePassword(newPassword);
                System.out.println("  密码修改成功。");
            } else {
                System.out.println("  密码错误，请重试。");
            }
        } else {
            System.out.println("  该会员ID不存在，请重试。");
        }
    }
} 