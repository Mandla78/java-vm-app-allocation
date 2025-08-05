
import java.util.*;

public class demo {
    public static void main(String[] args) {
        Virtually_Machine();
        Application();
        App_Allocation();
    }

    // Creating a Virtually_Machine Function
    public static void Virtually_Machine() {
        LinkedList<String> VirtuallyMachine = new LinkedList<String>();
        VirtuallyMachine.add(0, "VM1");
        VirtuallyMachine.add(1, "VM2");
        VirtuallyMachine.add(2, "VM3");
        VirtuallyMachine.add(3, "VM4");
        VirtuallyMachine.add(4, "VM5");
        VirtuallyMachine.add(5, "VM6");
        VirtuallyMachine.add(6, "VM7");
        VirtuallyMachine.add(7, "VM8");
        VirtuallyMachine.add(8, "VM9");
        VirtuallyMachine.add(9, "VM10");

        // printing Virtual Machines
        System.out.println("Available Virtual Machines: " + VirtuallyMachine);
    }

    // creating function for apps
    public static void Application(){
        LinkedList<String> Apps = new LinkedList<String>();
        Apps.add(0, "App1");
        Apps.add(1, "App2");
        Apps.add(2, "App3");
        Apps.add(3, "App4");
        Apps.add(4, "App5");

        System.out.println("Available Apps: "+ Apps);
    }

    // creating function for Allocating apps into VMs using loops and random assignment
    public static void App_Allocation(){
        // Re-create the lists of VMs and Apps (without modifying their original methods)
        LinkedList<String> VirtuallyMachine = new LinkedList<String>(
            Arrays.asList("VM1","VM2","VM3","VM4","VM5","VM6","VM7","VM8","VM9","VM10")
        );
        LinkedList<String> Apps = new LinkedList<String>(
            Arrays.asList("App1","App2","App3","App4","App5")
        );

        Map<String,String> AppAllocation = new HashMap<>();
        Map<String,String> VMStatus = new HashMap<>();
        Random rand = new Random();

        // Initialize all VMs to NOT BUSY
        for (String vm : VirtuallyMachine) {
            VMStatus.put(vm, "NOT BUSY");
        }

        // Loop through each app and allocate to a random available VM
        for (String app : Apps) {
            if (VirtuallyMachine.isEmpty()) {
                System.out.println("No available VM to allocate " + app);
                AppAllocation.put(app, "Not Allocated");
            } else {
                int idx = rand.nextInt(VirtuallyMachine.size());
                String vm = VirtuallyMachine.get(idx);
                AppAllocation.put(app, vm);
                VMStatus.put(vm, "BUSY (" + app + ")");
                System.out.println(app + " -> " + vm + " [BUSY]");
                VirtuallyMachine.remove(idx);
            }
        }

        // Print final statuses
        System.out.println("\nStatus of Virtual Machines:");
        for (int i = 1; i <= 10; i++) {
            String vmName = "VM" + i;
            if (VMStatus.containsKey(vmName)) {
                System.out.println(vmName + " -> " + VMStatus.get(vmName));
            } else {
                System.out.println(vmName + " -> NOT BUSY");
            }
        }
    }
}
