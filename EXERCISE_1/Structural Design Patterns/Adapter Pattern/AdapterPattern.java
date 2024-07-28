interface HDMI {
    void connectHDMI();
}

class VGAMonitor {
    public void connectVGA() {
        System.out.println("VGA monitor connected");
    }
}

class HDMIAdapter implements HDMI {
    private VGAMonitor vgaMonitor;

    public HDMIAdapter(VGAMonitor vgaMonitor) {
        this.vgaMonitor = vgaMonitor;
    }

    public void connectHDMI() {
        vgaMonitor.connectVGA();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        VGAMonitor vgaMonitor = new VGAMonitor();
        HDMI hdmi = new HDMIAdapter(vgaMonitor);
        hdmi.connectHDMI();
    }
}
