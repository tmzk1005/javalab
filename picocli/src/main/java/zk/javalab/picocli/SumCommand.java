package zk.javalab.picocli;

import picocli.CommandLine;

public class SumCommand {

    public static void main(String[] args) {
        SumConf sumConf = new SumConf();
        if (args.length == 0) {
            args = new String[] {"-x", "1", "-y", "2"};
        }
        int returnCode = new CommandLine(sumConf).execute(args);
        System.out.println("return Code is: " + returnCode);
        if (returnCode != 0) {
            System.exit(returnCode);
        }
        System.out.println("num1 is: " + sumConf.getNum1());
        System.out.println("num2 is: " + sumConf.getNum2());
    }

}
