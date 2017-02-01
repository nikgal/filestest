package by.galov.filemanager;
import by.galov.sql.*;
import java.util.Map;

public class DbCommand extends Command {

    public DbCommand(Map<String, String> args) {
        super(args);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.println("db cmd");
        SqlCon sc = new SqlCon();
        sc.getSqlCon();
    }

    @Override
    public void help() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCorrect() {
        // TODO Auto-generated method stub
        return true;
    }

}
