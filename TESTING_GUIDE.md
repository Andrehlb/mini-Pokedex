# Testing Guide for Pokemon Detail Screen

## Overview
This guide will help you test the newly implemented Pokemon detail screen features.

## Prerequisites
- Android Studio installed
- Android device or emulator (API 24+)
- Internet connection (for PokeAPI calls)

## Build and Install

### Option 1: Android Studio
1. Open the project in Android Studio
2. Let Gradle sync complete
3. Click "Run" (green play button) or press Shift+F10
4. Select your device/emulator
5. Wait for the app to install and launch

### Option 2: Command Line
```bash
# From the project root directory
./gradlew assembleDebug
./gradlew installDebug
```

If you encounter Gradle build issues, try:
```bash
./gradlew clean
./gradlew assembleDebug --refresh-dependencies
```

## Test Cases

### Test Case 1: Basic Detail View
**Steps:**
1. Launch the app
2. Wait for the Pokemon list to load
3. Tap on "Bulbasaur" (or any Pokemon)
4. Verify the detail screen appears

**Expected Results:**
- ✅ Pokemon image loads (larger 200x200 image)
- ✅ Name displays: "BULBASAUR" (uppercase)
- ✅ ID displays: "ID: 1"
- ✅ Types section shows: "Grass, Poison"
- ✅ Height shows: "0.7 m"
- ✅ Weight shows: "6.9 kg"
- ✅ Stats section displays:
  - HP: 45
  - Attack: 49
  - Defense: 49
  - Sp. Atk: 65
  - Sp. Def: 65
  - Speed: 45

### Test Case 2: Different Pokemon Types
**Test with Single Type Pokemon:**
1. Search for "Pikachu" in the main screen
2. Tap on Pikachu
3. Verify Types section shows: "Electric" (single type)

**Test with Dual Type Pokemon:**
1. Search for "Charizard"
2. Tap on Charizard
3. Verify Types section shows: "Fire, Flying" (two types)

### Test Case 3: Stats Verification
**Steps:**
1. Tap on different Pokemon
2. Verify all 6 stats are displayed
3. Check that stat values are reasonable (0-255 range)

**Test Pokemon:**
- Bulbasaur: Lower stats (good for testing)
- Mewtwo (if in list): High stats
- Ditto: Unique stats

### Test Case 4: Physical Attributes
**Steps:**
1. Test with small Pokemon (e.g., Pikachu)
   - Height should be around 0.4 m
   - Weight should be around 6.0 kg

2. Test with large Pokemon (e.g., Onix if available)
   - Height should be around 8.8 m
   - Weight should be around 210.0 kg

**Verify:**
- Units are displayed correctly (m for meters, kg for kilograms)
- Decimal formatting is correct (one decimal place)

### Test Case 5: Loading States
**Steps:**
1. Tap on a Pokemon
2. Watch for the progress indicator
3. Verify it disappears when data loads

**Expected:**
- ✅ Progress bar visible briefly while loading
- ✅ Progress bar disappears when data is loaded
- ✅ All fields populate correctly

### Test Case 6: Error Handling
**Steps:**
1. Enable Airplane mode on your device
2. Tap on a Pokemon
3. Observe error handling

**Expected:**
- ✅ Toast message appears with error
- ✅ App doesn't crash
- ✅ Can go back to list and try again

4. Disable Airplane mode
5. Tap on another Pokemon
6. Verify it works normally again

### Test Case 7: Scrolling
**Steps:**
1. On detail screen, scroll down
2. Verify all content is accessible

**Expected:**
- ✅ Can scroll to see all stats
- ✅ Layout doesn't cut off any information
- ✅ Scrolling is smooth

### Test Case 8: Navigation
**Steps:**
1. From main screen, tap a Pokemon
2. View detail screen
3. Press back button
4. Verify you return to the list

**Expected:**
- ✅ Back button returns to main screen
- ✅ List position is preserved
- ✅ Search query (if any) is preserved

### Test Case 9: Search Integration
**Steps:**
1. In main screen, search for "char"
2. Verify filtered list appears (Charmander, Charmeleon, Charizard)
3. Tap on Charizard
4. Verify detail screen shows correct data

**Expected:**
- ✅ Search works correctly
- ✅ Selected Pokemon's data loads
- ✅ All fields show Charizard's information

### Test Case 10: Multiple Sequential Views
**Steps:**
1. View details of Pokemon #1
2. Go back
3. View details of Pokemon #2
4. Go back
5. View details of Pokemon #3

**Expected:**
- ✅ Each detail screen loads correct data
- ✅ No data mixing between Pokemon
- ✅ Images update correctly
- ✅ No memory leaks or slowdowns

## What to Look For

### Visual Checks
- [ ] Pokemon image is clear and centered
- [ ] Text is readable and properly formatted
- [ ] Spacing and padding look good
- [ ] All labels are present
- [ ] Scrolling works on small screens

### Data Checks
- [ ] Pokemon name matches the one clicked
- [ ] ID is correct
- [ ] Types are capitalized properly
- [ ] Height/weight have correct units
- [ ] All 6 stats are present and have values
- [ ] Stats match official Pokemon data (check bulbapedia.bulbagarden.net)

### Functional Checks
- [ ] Loading indicator appears and disappears
- [ ] Error messages show when appropriate
- [ ] No crashes or freezes
- [ ] Back navigation works
- [ ] Multiple views don't cause issues

## Debugging Tips

### If the app crashes:
1. Check logcat in Android Studio
2. Look for stack traces
3. Verify internet connection
4. Check if PokeAPI is accessible: https://pokeapi.co/api/v2/pokemon/1

### If data doesn't display:
1. Check network connectivity
2. Look for API errors in logcat
3. Verify the Pokemon ID is valid (1-1025)
4. Check binding adapters are working

### If images don't load:
1. Verify internet connection
2. Check Coil library is properly initialized
3. Look for image URL in API response
4. Check placeholder/error images display

## API Testing
You can manually test the API endpoint used:
```bash
# Test Bulbasaur (ID: 1)
curl https://pokeapi.co/api/v2/pokemon/1

# Test Pikachu (ID: 25)
curl https://pokeapi.co/api/v2/pokemon/25
```

The response should include:
- `id`: Pokemon ID
- `name`: Pokemon name
- `height`: In decimeters
- `weight`: In hectograms
- `types`: Array of type objects
- `stats`: Array of stat objects with base_stat values

## Performance Testing
1. Test with slow internet connection
2. Test with 3G/4G vs WiFi
3. Test rapid tapping on multiple Pokemon
4. Test with low memory device
5. Test with large Pokemon IDs (e.g., 1000+)

## Reporting Issues
If you find any bugs, please report with:
- Device/emulator info
- Android version
- Steps to reproduce
- Expected vs actual behavior
- Screenshots if applicable
- Logcat output if crash occurs

## Success Criteria
✅ All test cases pass
✅ No crashes or freezes
✅ Data displays correctly for all Pokemon
✅ UI is smooth and responsive
✅ Error handling works properly
✅ Navigation works as expected

## Notes
- First load may be slower due to image caching
- Some Pokemon may have unusual stats (e.g., Shedinja has 1 HP)
- API rate limit: 100 requests per minute (should be fine for testing)
- The app requires Android API 24+ (Android 7.0+)
