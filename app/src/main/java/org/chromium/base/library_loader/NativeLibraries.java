package org.chromium.base.library_loader;
public class NativeLibraries {
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 2;
    public static final int CPU_FAMILY_X86 = 3;
    public static boolean sUseLinker = false;
    public static boolean sUseLibraryInZipFile = false;
    public static boolean sEnableLinkerTests = false;
    public static final String[] LIBRARIES =
      {"content_shell_content_view"};
    static String sVersionNumber =
      "70.0.3522.0";
    public static int sCpuFamily =
        CPU_FAMILY_UNKNOWN;
}
