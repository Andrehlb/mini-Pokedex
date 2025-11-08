# Pokemon Detail Screen - Visual Layout

## Layout Structure

```
┌──────────────────────────────────────┐
│         [Pokemon Image]              │
│           200x200dp                  │
│                                      │
└──────────────────────────────────────┘
                  ▼
┌──────────────────────────────────────┐
│          BULBASAUR                   │
│         (32sp, Bold)                 │
└──────────────────────────────────────┘
                  ▼
┌──────────────────────────────────────┐
│            ID: 1                     │
│          (18sp)                      │
└──────────────────────────────────────┘
                  ▼
┌──────────────────────────────────────┐
│            Tipos                     │
│         (20sp, Bold)                 │
└──────────────────────────────────────┘
                  ▼
┌──────────────────────────────────────┐
│       Grass, Poison                  │
│          (16sp)                      │
└──────────────────────────────────────┘
                  ▼
┌──────────────┬───────────────────────┐
│    Altura    │        Peso           │
│   (Bold)     │      (Bold)           │
├──────────────┼───────────────────────┤
│    0.7 m     │      6.9 kg           │
│   (18sp)     │      (18sp)           │
└──────────────┴───────────────────────┘
                  ▼
┌──────────────────────────────────────┐
│            Stats                     │
│         (20sp, Bold)                 │
└──────────────────────────────────────┘
                  ▼
┌──────────────────────────────────────┐
│  HP              45                  │
│  Attack          49                  │
│  Defense         49                  │
│  Sp. Atk         65                  │
│  Sp. Def         65                  │
│  Speed           45                  │
│         (16sp each)                  │
└──────────────────────────────────────┘
```

## Example with Real Data

### Pokemon: Bulbasaur (#1)

```
╔══════════════════════════════════════╗
║                                      ║
║          [Bulbasaur Image]           ║
║        (Green dinosaur with          ║
║         bulb on back)                ║
║                                      ║
╚══════════════════════════════════════╝

         ████ BULBASAUR ████
              
                ID: 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              Tipos
        Grass, Poison

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    Altura          Peso
    0.7 m          6.9 kg

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              Stats

    HP                45
    Attack            49
    Defense           49
    Sp. Atk           65
    Sp. Def           65
    Speed             45

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

### Pokemon: Charizard (#6)

```
╔══════════════════════════════════════╗
║                                      ║
║         [Charizard Image]            ║
║      (Orange dragon with wings       ║
║         and tail flame)              ║
║                                      ║
╚══════════════════════════════════════╝

         ████ CHARIZARD ████
              
                ID: 6

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              Tipos
        Fire, Flying

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    Altura          Peso
    1.7 m         90.5 kg

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              Stats

    HP                78
    Attack            84
    Defense           78
    Sp. Atk          109
    Sp. Def           85
    Speed            100

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

### Pokemon: Pikachu (#25)

```
╔══════════════════════════════════════╗
║                                      ║
║          [Pikachu Image]             ║
║       (Yellow mouse with             ║
║        lightning tail)               ║
║                                      ║
╚══════════════════════════════════════╝

         ████ PIKACHU ████
              
               ID: 25

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              Tipos
           Electric

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    Altura          Peso
    0.4 m          6.0 kg

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              Stats

    HP                35
    Attack            55
    Defense           40
    Sp. Atk           50
    Sp. Def           50
    Speed             90

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

## Layout Specifications

### Spacing & Padding
- **Outer padding**: 16dp on all sides
- **Section spacing**: 24dp between major sections
- **Item spacing**: 8dp between items in a section
- **Stat spacing**: 8dp between each stat row

### Text Sizes
- **Pokemon Name**: 32sp, Bold, Uppercase
- **Pokemon ID**: 18sp, Normal
- **Section Headers**: 20sp, Bold ("Tipos", "Stats")
- **Section Content**: 16sp, Normal (types)
- **Stat Labels**: 16sp, Normal
- **Stat Values**: 16sp, Bold
- **Physical Attributes**: 18sp, Normal

### Image
- **Size**: 200dp x 200dp
- **Position**: Centered horizontally
- **Top margin**: 16dp
- **Placeholder**: Gray Pokemon silhouette
- **Error**: Red "X" icon

### Colors
- Text: Default (system)
- Background: Default (system)
- Future enhancement: Type-based colors for type badges

### Scrolling
- Entire content in ScrollView
- Scrollable if content exceeds screen height
- Smooth scrolling behavior

## Loading State

```
┌──────────────────────────────────────┐
│                                      │
│                                      │
│                                      │
│                                      │
│          ⟳ Loading...                │
│      (Progress Indicator)            │
│                                      │
│                                      │
│                                      │
│                                      │
└──────────────────────────────────────┘
```

## Error State

When API call fails:
```
┌──────────────────────────────────────┐
│         [Pokemon Image]              │
│      (Shows previous data            │
│       or placeholder)                │
└──────────────────────────────────────┘
         
         ▼ Toast Message ▼
    "Erro ao carregar detalhes:
     Unable to resolve host..."
```

## Responsive Behavior

### Small Screens (< 600dp height)
- Content scrolls
- All sections remain visible
- Stats section most likely requires scroll

### Medium Screens (600-800dp height)
- Most content visible without scroll
- May need slight scroll for bottom stats

### Large Screens (> 800dp height)
- All content visible without scrolling
- Extra space at bottom

## Accessibility

- All images have contentDescription
- Text is scalable (uses sp units)
- Sufficient contrast ratios
- Touch targets are large enough
- Screen reader compatible

## Animation Notes (Future Enhancement)

Suggested animations:
1. Image fade-in when loaded
2. Stats count-up animation
3. Slide-in for content sections
4. Shimmer effect during loading
5. Type badge tap effects

## Color Scheme (Future Enhancement)

Type-based background colors:
- Fire: #F08030
- Water: #6890F0
- Grass: #78C850
- Electric: #F8D030
- Psychic: #F85888
- Ice: #98D8D8
- Dragon: #7038F8
- Dark: #705848
- Fairy: #EE99AC
- Normal: #A8A878
- Fighting: #C03028
- Flying: #A890F0
- Poison: #A040A0
- Ground: #E0C068
- Rock: #B8A038
- Bug: #A8B820
- Ghost: #705898
- Steel: #B8B8D0

---

**Note**: This is the current implementation. The layout is clean, functional, and ready for testing. Future enhancements could add more visual polish with colors, progress bars for stats, and animations.
