# IntelliJ Setup Guide

## 🔧 Step 1: Open the Project in IntelliJ

1. Open IntelliJ IDEA
2. **File → Open** (or **Open** from welcome screen)
3. Navigate to: `/Users/maliek.borwin/workspace/6G5Z0059-2526-student/1CWK100Architecture`
4. Select the **`1CWK100Architecture`** folder (the one with `pom.xml` inside)
5. Click **Open**

---

## 🔄 Step 2: Import as Maven Project

IntelliJ should automatically detect the `pom.xml` file and ask you to import it. If it does:

1. Click **"Trust Project"** if prompted
2. Click **"Import Maven Project"** or **"Add as Maven Project"**

**If it doesn't automatically detect:**

1. Right-click on the **`pom.xml`** file in the Project Explorer
2. Select **"Add as Maven Project"** or **"Maven → Reload Project"**

---

## 📦 Step 3: Wait for Maven to Download Dependencies

You'll see a progress bar at the bottom of IntelliJ. Wait for it to finish:
- Downloading dependencies
- Indexing files
- Building the project

This might take a few minutes the first time.

---

## ✅ Step 4: Verify Project Structure

After Maven finishes, you should see:
- A **Maven** tool window (usually on the right side)
- Your source files in `src/main/java/uk/ac/mmu/game/...`
- No red error marks on files

---

## 🚀 Step 5: Run the Application

### Method 1: Run from Main Class (Easiest)

1. Open `SoftwareProduct.java` in the editor
2. Look for the `main` method
3. You should see a **green play button (▶)** next to the `main` method or class name
4. Click the green play button
5. Select **"Run 'SoftwareProduct.main()'"**

### Method 2: Create Run Configuration

1. **Run → Edit Configurations...**
2. Click the **+** button (top left)
3. Select **"Spring Boot"**
4. Set:
   - **Name**: `Dice Game`
   - **Main class**: `uk.ac.mmu.game.SoftwareProduct`
   - **Module**: `game`
5. Click **OK**
6. Click the green play button in the toolbar

### Method 3: Use Maven Tool Window

1. Open the **Maven** tool window (View → Tool Windows → Maven)
2. Expand: `game → Plugins → spring-boot`
3. Double-click **`spring-boot:run`**

---

## 🐛 Troubleshooting

### If you don't see the green play button:

1. **Check Project SDK:**
   - **File → Project Structure** (or `⌘;` on Mac, `Ctrl+Alt+Shift+S` on Windows)
   - **Project → SDK**: Should be Java 21 or higher
   - If not, click dropdown and select Java 21

2. **Reimport Maven:**
   - Right-click `pom.xml`
   - **Maven → Reload Project**

3. **Invalidate Caches:**
   - **File → Invalidate Caches...**
   - Check "Clear file system cache and Local History"
   - Click **Invalidate and Restart**

### If you see "Cannot resolve symbol" errors:

1. Wait for Maven to finish downloading dependencies
2. **File → Invalidate Caches → Invalidate and Restart**
3. After restart, right-click `pom.xml` → **Maven → Reload Project**

### If Spring Boot isn't recognized:

1. Make sure `pom.xml` is recognized as a Maven project
2. Check that Spring Boot dependencies are downloaded (Maven tool window)
3. Try: **File → Invalidate Caches → Invalidate and Restart**

---

## 📋 Quick Checklist

- [ ] Project opened in IntelliJ
- [ ] `pom.xml` recognized as Maven project
- [ ] Maven dependencies downloaded (no progress bar)
- [ ] Project SDK set to Java 21
- [ ] Green play button visible next to `main` method
- [ ] Application runs without errors

---

## 🎯 Expected Output When Running

When you run the application, you should see:

```
dice1: DiceRoll(6)
dice1 == dice2: false
dice1.equals(dice2): true
dice1.equals(dice3): false
Hash codes match: true
Played Game Id = 1
Enter a Game Id to replay.
```

The error at the end is normal (Replay is waiting for input).

---

**Need more help?** Check the IntelliJ documentation or ask for assistance!

