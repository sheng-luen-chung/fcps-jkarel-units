# fcps-jkarel-units — Java 教學教材(學生版)

以 FCPS(Fairfax County Public Schools)Karel J Robot 課程為基礎的 Java 教材,
每個 Unit 是一個**獨立的 Eclipse 專案**,從 Karel 機器人入門一路到 Swing GUI、物件導向與資料處理。

> 🚀 **第一次安裝環境?** 先看 **[安裝手冊.md](安裝手冊.md)** —— 從零開始(裝 JDK、Eclipse 或
> VS Code、打開專案、跑出第一支程式)的逐步流程。

## 課程地圖

| 專案 | 主題 |
|------|------|
| Unit1 | Karel 機器人:基本指令、方法分解、控制流程、遞迴入門 |
| Unit2 | Swing 繪圖與動畫:JPanel、paintComponent、Timer、碰撞偵測、ArrayList |
| Unit3 | GUI 元件與事件驅動:JButton、ActionListener、版面配置 |
| Unit4 | 物件導向:類別設計、繼承(Shape/Circle/Square)、陣列 |
| Unit5 | 資料處理:排序(Selection Sort)、字串處理、遞迴、二分搜尋 |
| SetupFiles | 環境檢查工具(CheckEnv)與必要的 jar 檔 |

每個 Unit 裡有多個 Lab,部分 Lab **刻意留白**給你完成(見下方「學生版的紅字是正常的」)。

## Java 環境需求

- **任何 JDK 8 以上都可以**(VS Code 的 Java 功能需要 17+;建議直接裝 **JDK 21 LTS**,兩種 IDE 都通)。
- 所有專案的**語言層級鎖定 Java 8**(compliance 1.8),所以無論用哪個 JDK,語法與語意都一致。
- `.classpath` 一律**不鎖定特定 JRE**,使用 workspace 預設——避免「no strictly compatible JRE」警告。
- 檔案編碼一律 **UTF-8**,中文註解與字串在任何機器上都不會亂碼。

## 確認 Java 環境(跑 CheckEnv)

開 `SetupFiles/src/CheckEnv.java` 直接 Run,它印出**執行當下**的 `java.version`、`java.home`、
`file.encoding`,最後一行中文若是亂碼代表 console 編碼有問題。到任何新機器,第一件事就是跑它。
(逐步操作見 [安裝手冊.md](安裝手冊.md)。)

## 在 Eclipse 匯入

1. `File → Import → General → Existing Projects into Workspace`。
2. Root directory 選這個 repo 的根目錄,勾選要用的 Unit 專案(每個 Unit 是獨立專案,可只匯入需要的)。
3. **不要勾 "Copy projects into workspace"**,直接在原位置使用。
4. Karel 相關專案(Unit1 / Unit2 / Unit5)需要 `karel2_c.jar` 與 `xercesImpl.jar`,各專案的
   `.classpath` 已掛好專案內附的 jar,匯入後即可直接執行。
5. Karel 地圖檔在 `Unit1/maps/`,程式以相對路徑 `maps/xxx.map` 讀取,執行時的 working
   directory 須是專案根目錄(Eclipse 預設即是)。

## 在 VS Code 開啟與執行

安裝 **Extension Pack for Java** 後,VS Code 底層用的就是 Eclipse 的 JDT 語言伺服器,**直接讀
各專案的 `.project` / `.classpath`**,不需要轉成 Maven/Gradle、也不必改目錄結構。第一次打開時
右下角會建議安裝擴充套件(已寫在 `.vscode/extensions.json`),按下去裝即可。

**兩種開法**:
- **跑某一個 Unit(最單純)**:`File → Open Folder…` 直接開那個 Unit 資料夾(例如 `Unit1`)。
  此時工作目錄就是該專案根目錄,Karel 的 `maps/xxx.map`、專案內的 jar 全部就位。
- **一次看整包**:`File → Open Workspace from File…` → 選 **`fcps-jkarel-units.code-workspace`**。
  它把每個 Unit 列為獨立資料夾,執行時 cwd 仍會落在「該檔所屬的 Unit 根目錄」,maps 一樣讀得到。

> ⚠️ **不要**用 `Open Folder…` 開「repo 根目錄」再去跑 Karel 程式——那樣工作目錄會是 repo 根
> 而非 Unit 根,`maps/xxx.map` 會找不到。要嘛開單一 Unit 資料夾,要嘛用 `.code-workspace`。
> (只有 Unit1 會讀 maps,其餘 Unit 沒這顧慮,但統一照這規則最不會出錯。)

**執行**:任一含 `main` 的 `.java` 檔上方會出現 **Run | Debug** 的 CodeLens,直接按 Run。

**指定 JDK(選用)**:教材鎖 1.8,VS Code 用哪顆 JDK 跑都不影響行為。要明確指定,在你自己的
**User Settings**(不是專案設定,因為 JDK 路徑每台機器不同)加 `java.configuration.runtimes`。

## 學生版的紅字是正常的

有些 Lab 刻意**留白**——缺 return 的方法、要你自己寫的類別(如 Unit1 的 `Athlete` / `Racer`、
Unit5 Lab04 的 `Weight`)、要你除錯的語法錯誤(Unit4 Lab02)。這些 Lab 在 Eclipse / VS Code
顯示紅字是**教材設計**,不是環境問題:

> Unit1(Lab08 等)、Unit2 Lab11、Unit3 Lab04/06/07、Unit4 Lab02/05/07/09/13/15、
> Unit5 Lab02/04/07/08/10/11/15。

以上之外的 Lab 全數編譯通過。看到紅字先對照這份清單,別以為是環境裝壞了。

## 專案結構(各 Unit 原始碼擺法)

- **Unit1**:`src/` 下平鋪、default package。
- **Unit2**:`src/LabNN/`,且檔案有 `package LabNN;` 宣告。
- **Unit3 / Unit4 / Unit5**:每個 Lab 資料夾是獨立的 source folder、檔案無 package 宣告(default package)。
- 需要 Karel 函式庫的專案(Unit1、Unit2、Unit5),`karel2_c.jar` 與 `xercesImpl.jar` 都放在
  **該專案自己的根目錄**並以相對路徑掛載——每個專案完全自包含,單獨匯入或整包複製都能用。

**所有 .java 檔一律 UTF-8 編碼。**
