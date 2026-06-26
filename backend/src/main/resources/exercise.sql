-- =====================================================
-- FitMentor AI Exercise Database
-- =====================================================

INSERT INTO exercises
(name, description, muscle_group, equipment, difficulty, exercise_type,
 instructions, tips, calories_burned_per_minute,
 compound_exercise, premium_exercise, image_url, video_url)

VALUES

-- =========================
-- CHEST
-- =========================

(
    'Bench Press',
    'Classic compound chest exercise.',
    'CHEST',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Lower the bar slowly to your chest and press upward.',
    'Keep your feet planted throughout.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Incline Bench Press',
    'Targets the upper chest.',
    'CHEST',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Press the bar upward on an incline bench.',
    'Do not lock your elbows.',
    8.5,
    true,
    false,
    NULL,
    NULL
),

(
    'Decline Bench Press',
    'Targets lower chest muscles.',
    'CHEST',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Lower bar with control then press.',
    'Maintain shoulder stability.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Push Up',
    'Bodyweight chest exercise.',
    'CHEST',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Lower yourself until your chest nearly touches the floor.',
    'Keep body straight.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Diamond Push Up',
    'Push-up variation emphasizing inner chest and triceps.',
    'CHEST',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Place hands close together forming a diamond.',
    'Keep elbows close.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Chest Fly',
    'Isolation movement for chest.',
    'CHEST',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Lower dumbbells in a wide arc and squeeze.',
    'Maintain slight bend in elbows.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Incline Dumbbell Press',
    'Upper chest dumbbell press.',
    'CHEST',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Press dumbbells upward.',
    'Control the lowering phase.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Flat Dumbbell Press',
    'Chest press using dumbbells.',
    'CHEST',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Press dumbbells above chest.',
    'Avoid bouncing.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Cable Fly',
    'Constant tension chest isolation.',
    'CHEST',
    'CABLE',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Bring handles together slowly.',
    'Squeeze chest at top.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Pec Deck',
    'Machine chest fly.',
    'CHEST',
    'MACHINE',
    'BEGINNER',
    'HYPERTROPHY',
    'Bring pads together.',
    'Slow eccentric.',
    5,
    false,
    false,
    NULL,
    NULL
)

        ,

(
    'Machine Chest Press',
    'Chest press using machine.',
    'CHEST',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Push handles forward until arms extend.',
    'Control the return movement.',
    6,
    true,
    false,
    NULL,
    NULL
),

(
    'Decline Push Up',
    'Push-up variation targeting lower chest.',
    'CHEST',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Keep feet elevated and lower chest.',
    'Maintain a straight body.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Dips',
    'Compound chest and triceps exercise.',
    'CHEST',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Lower body until shoulders reach elbows.',
    'Lean slightly forward.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Svend Press',
    'Chest squeeze exercise.',
    'CHEST',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Press plates together while extending arms.',
    'Maintain constant chest tension.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Single Arm Cable Fly',
    'Unilateral chest isolation.',
    'CHEST',
    'CABLE',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Pull cable across the body.',
    'Squeeze chest at the end.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Incline Cable Fly',
    'Upper chest cable fly.',
    'CHEST',
    'CABLE',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Bring handles together upward.',
    'Keep slight elbow bend.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Medicine Ball Push Up',
    'Explosive chest exercise.',
    'CHEST',
    'MEDICINE_BALL',
    'ADVANCED',
    'STRENGTH',
    'Perform push-up with hands on medicine ball.',
    'Control balance.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Resistance Band Chest Press',
    'Chest press using resistance bands.',
    'CHEST',
    'RESISTANCE_BAND',
    'BEGINNER',
    'STRENGTH',
    'Press bands forward.',
    'Control both phases.',
    6,
    true,
    false,
    NULL,
    NULL
),

(
    'Wide Push Up',
    'Wide grip push-up.',
    'CHEST',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Perform push-up with wide hand placement.',
    'Do not flare elbows excessively.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Close Grip Push Up',
    'Chest and triceps focused push-up.',
    'CHEST',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Keep hands shoulder-width apart.',
    'Maintain body alignment.',
    7,
    true,
    false,
    NULL,
    NULL
)

,

-- =========================
-- BACK
-- =========================

(
    'Pull Up',
    'Classic upper back bodyweight exercise.',
    'BACK',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Pull yourself until your chin crosses the bar.',
    'Avoid swinging.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Chin Up',
    'Bodyweight pulling exercise emphasizing lats and biceps.',
    'BACK',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Pull until chin passes the bar.',
    'Use full range of motion.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Lat Pulldown',
    'Machine exercise targeting the latissimus dorsi.',
    'BACK',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Pull the bar to your upper chest.',
    'Avoid leaning excessively.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Barbell Row',
    'Compound back exercise.',
    'BACK',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Pull the bar toward your abdomen.',
    'Keep your back neutral.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Dumbbell Row',
    'Single-arm rowing movement.',
    'BACK',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Pull dumbbell toward hip.',
    'Squeeze shoulder blade.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'T-Bar Row',
    'Heavy rowing exercise for middle back.',
    'BACK',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Pull handle toward chest.',
    'Do not jerk the weight.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Seated Cable Row',
    'Cable rowing movement.',
    'BACK',
    'CABLE',
    'BEGINNER',
    'STRENGTH',
    'Pull handle toward abdomen.',
    'Keep chest upright.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Face Pull',
    'Rear delt and upper back exercise.',
    'BACK',
    'CABLE',
    'BEGINNER',
    'STRENGTH',
    'Pull rope toward forehead.',
    'Lead with elbows.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Straight Arm Pulldown',
    'Isolation exercise for lats.',
    'BACK',
    'CABLE',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Pull cable downward with straight arms.',
    'Squeeze lats.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Deadlift',
    'Full-body compound lift emphasizing posterior chain.',
    'BACK',
    'BARBELL',
    'ADVANCED',
    'STRENGTH',
    'Lift bar by extending hips and knees.',
    'Maintain a neutral spine.',
    12,
    true,
    false,
    NULL,
    NULL
),

(
    'Romanian Deadlift',
    'Posterior chain exercise.',
    'BACK',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Hinge at hips and lower bar.',
    'Keep bar close to legs.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Inverted Row',
    'Bodyweight rowing exercise.',
    'BACK',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Pull chest toward the bar.',
    'Keep body straight.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Reverse Fly',
    'Rear shoulder and upper back isolation.',
    'BACK',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise dumbbells outward.',
    'Slight bend in elbows.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Machine Row',
    'Seated machine rowing movement.',
    'BACK',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Pull handles toward torso.',
    'Squeeze shoulder blades.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Meadows Row',
    'Landmine row variation.',
    'BACK',
    'BARBELL',
    'ADVANCED',
    'STRENGTH',
    'Row landmine bar toward hip.',
    'Stretch fully at bottom.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Wide Grip Lat Pulldown',
    'Wide grip variation for lats.',
    'BACK',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Pull bar toward upper chest.',
    'Control the eccentric.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Close Grip Lat Pulldown',
    'Close grip variation for lower lats.',
    'BACK',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Pull close-grip attachment toward chest.',
    'Do not lean back excessively.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Superman',
    'Lower back strengthening exercise.',
    'BACK',
    'BODYWEIGHT',
    'BEGINNER',
    'MOBILITY',
    'Lift arms and legs off the floor.',
    'Squeeze glutes.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Resistance Band Row',
    'Back exercise using resistance bands.',
    'BACK',
    'RESISTANCE_BAND',
    'BEGINNER',
    'STRENGTH',
    'Pull handles toward torso.',
    'Maintain posture.',
    6,
    true,
    false,
    NULL,
    NULL
),

(
    'Single Arm Cable Row',
    'Unilateral cable row.',
    'BACK',
    'CABLE',
    'INTERMEDIATE',
    'STRENGTH',
    'Pull handle toward waist.',
    'Rotate slightly naturally.',
    7,
    true,
    false,
    NULL,
    NULL
)

,

-- =========================
-- LEGS
-- =========================

(
    'Squat',
    'Classic lower body compound exercise.',
    'QUADRICEPS',
    'BARBELL',
    'BEGINNER',
    'STRENGTH',
    'Lower hips until thighs are parallel to the floor.',
    'Keep chest up and knees tracking over toes.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Front Squat',
    'Front-loaded squat emphasizing quadriceps.',
    'QUADRICEPS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Keep elbows high while squatting.',
    'Maintain upright torso.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Goblet Squat',
    'Dumbbell squat suitable for beginners.',
    'QUADRICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Hold dumbbell close to chest and squat.',
    'Push knees outward.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Leg Press',
    'Machine exercise for lower body.',
    'QUADRICEPS',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Push platform away using heels.',
    'Avoid locking knees.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Hack Squat',
    'Machine squat variation.',
    'QUADRICEPS',
    'MACHINE',
    'INTERMEDIATE',
    'STRENGTH',
    'Lower under control then press upward.',
    'Keep back against the pad.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Walking Lunges',
    'Dynamic unilateral leg exercise.',
    'QUADRICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Step forward into a lunge and alternate legs.',
    'Keep torso upright.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Reverse Lunges',
    'Backward lunge variation.',
    'QUADRICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Step backward into lunge.',
    'Drive through front heel.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Bulgarian Split Squat',
    'Single-leg strength exercise.',
    'QUADRICEPS',
    'DUMBBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Rear foot elevated on bench.',
    'Keep front knee stable.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Step Up',
    'Single-leg strengthening movement.',
    'QUADRICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Step onto a platform and drive upward.',
    'Avoid pushing with rear leg.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Leg Extension',
    'Quadriceps isolation exercise.',
    'QUADRICEPS',
    'MACHINE',
    'BEGINNER',
    'HYPERTROPHY',
    'Extend knees fully.',
    'Control lowering.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Romanian Deadlift',
    'Hamstring-focused hip hinge.',
    'HAMSTRINGS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Hinge hips while lowering bar.',
    'Keep back flat.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Leg Curl',
    'Hamstring isolation exercise.',
    'HAMSTRINGS',
    'MACHINE',
    'BEGINNER',
    'HYPERTROPHY',
    'Curl heels toward glutes.',
    'Squeeze hamstrings.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Seated Leg Curl',
    'Machine hamstring curl.',
    'HAMSTRINGS',
    'MACHINE',
    'BEGINNER',
    'HYPERTROPHY',
    'Curl under control.',
    'Avoid swinging.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Glute Bridge',
    'Bodyweight glute exercise.',
    'GLUTES',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Raise hips until body forms a straight line.',
    'Squeeze glutes.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Hip Thrust',
    'Glute-focused compound movement.',
    'GLUTES',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Drive hips upward.',
    'Pause at the top.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Cable Kickback',
    'Glute isolation exercise.',
    'GLUTES',
    'CABLE',
    'BEGINNER',
    'HYPERTROPHY',
    'Kick leg backward.',
    'Control movement.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Standing Calf Raise',
    'Calf strengthening exercise.',
    'CALVES',
    'MACHINE',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise heels as high as possible.',
    'Stretch fully at bottom.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Seated Calf Raise',
    'Soleus-focused calf exercise.',
    'CALVES',
    'MACHINE',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise heels upward while seated.',
    'Pause at top.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Donkey Calf Raise',
    'Bodyweight calf exercise.',
    'CALVES',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Raise heels while bent over.',
    'Full range of motion.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Wall Sit',
    'Isometric lower body exercise.',
    'QUADRICEPS',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Hold seated position against wall.',
    'Keep thighs parallel.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Jump Squat',
    'Explosive squat movement.',
    'QUADRICEPS',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'HIIT',
    'Jump explosively from squat.',
    'Land softly.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Box Jump',
    'Plyometric leg exercise.',
    'QUADRICEPS',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'HIIT',
    'Jump onto sturdy platform.',
    'Step down carefully.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Sumo Squat',
    'Wide stance squat variation.',
    'GLUTES',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Keep toes outward and squat.',
    'Drive through heels.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Curtsy Lunge',
    'Targets glutes and inner thighs.',
    'GLUTES',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Cross one leg behind while lunging.',
    'Maintain balance.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Resistance Band Squat',
    'Band-resisted squat.',
    'QUADRICEPS',
    'RESISTANCE_BAND',
    'BEGINNER',
    'STRENGTH',
    'Perform squat against band resistance.',
    'Keep knees outward.',
    7,
    true,
    false,
    NULL,
    NULL
)
,

-- =========================
-- SHOULDERS
-- =========================

(
    'Overhead Press',
    'Compound shoulder press.',
    'SHOULDERS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Press the bar overhead until arms are fully extended.',
    'Keep core tight throughout.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Seated Dumbbell Shoulder Press',
    'Seated shoulder press using dumbbells.',
    'SHOULDERS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Press dumbbells overhead.',
    'Avoid arching your back.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Arnold Press',
    'Rotational shoulder press.',
    'SHOULDERS',
    'DUMBBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Rotate palms while pressing.',
    'Perform slowly.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Lateral Raise',
    'Isolation exercise for side delts.',
    'SHOULDERS',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise dumbbells until shoulder height.',
    'Avoid swinging.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Front Raise',
    'Isolation exercise for front delts.',
    'SHOULDERS',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise dumbbells in front.',
    'Keep elbows slightly bent.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Rear Delt Fly',
    'Targets rear deltoids.',
    'SHOULDERS',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise dumbbells outward while bent over.',
    'Squeeze rear delts.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Cable Lateral Raise',
    'Cable side delt exercise.',
    'SHOULDERS',
    'CABLE',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Raise cable sideways.',
    'Control movement.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Machine Shoulder Press',
    'Machine shoulder press.',
    'SHOULDERS',
    'MACHINE',
    'BEGINNER',
    'STRENGTH',
    'Press handles overhead.',
    'Do not lock elbows.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Upright Row',
    'Targets traps and shoulders.',
    'SHOULDERS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Pull bar to chest level.',
    'Keep elbows above wrists.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Face Pull',
    'Rear shoulder exercise.',
    'SHOULDERS',
    'CABLE',
    'BEGINNER',
    'HYPERTROPHY',
    'Pull rope toward forehead.',
    'Lead with elbows.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Push Press',
    'Explosive overhead press.',
    'SHOULDERS',
    'BARBELL',
    'ADVANCED',
    'STRENGTH',
    'Use slight leg drive before pressing.',
    'Explode upward.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Landmine Press',
    'Shoulder press using landmine attachment.',
    'SHOULDERS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Press bar upward diagonally.',
    'Maintain core stability.',
    7,
    true,
    false,
    NULL,
    NULL
),

(
    'Plate Front Raise',
    'Front delt exercise using weight plate.',
    'SHOULDERS',
    'BARBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise plate to shoulder level.',
    'Move slowly.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Resistance Band Lateral Raise',
    'Band shoulder exercise.',
    'SHOULDERS',
    'RESISTANCE_BAND',
    'BEGINNER',
    'HYPERTROPHY',
    'Raise handles sideways.',
    'Keep tension throughout.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Pike Push Up',
    'Bodyweight shoulder exercise.',
    'SHOULDERS',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Lower head toward floor then press.',
    'Keep hips high.',
    8,
    true,
    false,
    NULL,
    NULL
)

,

-- =========================
-- BICEPS
-- =========================

(
    'Barbell Curl',
    'Classic biceps exercise.',
    'BICEPS',
    'BARBELL',
    'BEGINNER',
    'STRENGTH',
    'Curl barbell toward shoulders.',
    'Keep elbows fixed.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Dumbbell Curl',
    'Alternating dumbbell curl.',
    'BICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Curl dumbbells upward.',
    'Avoid swinging.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Hammer Curl',
    'Targets brachialis and forearms.',
    'BICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Keep palms facing each other.',
    'Move under control.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Concentration Curl',
    'Isolation curl for peak contraction.',
    'BICEPS',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Curl while elbow rests on thigh.',
    'Squeeze at top.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Preacher Curl',
    'Machine/bench curl.',
    'BICEPS',
    'BARBELL',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Curl over preacher bench.',
    'Lower slowly.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Cable Curl',
    'Cable biceps curl.',
    'BICEPS',
    'CABLE',
    'BEGINNER',
    'HYPERTROPHY',
    'Curl cable toward shoulders.',
    'Maintain tension.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Incline Dumbbell Curl',
    'Stretch-focused biceps exercise.',
    'BICEPS',
    'DUMBBELL',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Curl from incline bench.',
    'Do not move shoulders.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Spider Curl',
    'Bench-supported curl.',
    'BICEPS',
    'DUMBBELL',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Curl while chest rests on bench.',
    'Full contraction.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Reverse Curl',
    'Targets brachioradialis.',
    'BICEPS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Use overhand grip.',
    'Keep wrists neutral.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Resistance Band Curl',
    'Band-based curl.',
    'BICEPS',
    'RESISTANCE_BAND',
    'BEGINNER',
    'STRENGTH',
    'Curl against band resistance.',
    'Slow eccentric.',
    5,
    false,
    false,
    NULL,
    NULL
),

-- =========================
-- TRICEPS
-- =========================

(
    'Tricep Pushdown',
    'Cable triceps exercise.',
    'TRICEPS',
    'CABLE',
    'BEGINNER',
    'STRENGTH',
    'Push rope downward until elbows extend.',
    'Keep elbows close.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Overhead Tricep Extension',
    'Long-head focused movement.',
    'TRICEPS',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Extend dumbbell overhead.',
    'Avoid elbow flare.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Skull Crusher',
    'Lying triceps extension.',
    'TRICEPS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Lower bar toward forehead then extend.',
    'Control the weight.',
    7,
    false,
    false,
    NULL,
    NULL
),

(
    'Bench Dips',
    'Bodyweight triceps exercise.',
    'TRICEPS',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Lower body using bench.',
    'Keep elbows tucked.',
    6,
    false,
    false,
    NULL,
    NULL
),

(
    'Close Grip Bench Press',
    'Compound triceps exercise.',
    'TRICEPS',
    'BARBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Use narrow grip while pressing.',
    'Do not flare elbows.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Cable Overhead Extension',
    'Cable overhead triceps extension.',
    'TRICEPS',
    'CABLE',
    'INTERMEDIATE',
    'HYPERTROPHY',
    'Extend rope overhead.',
    'Stretch fully.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Single Arm Pushdown',
    'Unilateral cable pushdown.',
    'TRICEPS',
    'CABLE',
    'BEGINNER',
    'HYPERTROPHY',
    'Push handle downward.',
    'Keep elbow fixed.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Kickback',
    'Isolation triceps movement.',
    'TRICEPS',
    'DUMBBELL',
    'BEGINNER',
    'HYPERTROPHY',
    'Extend arm backward.',
    'Squeeze triceps.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Diamond Bench Press',
    'Press variation emphasizing triceps.',
    'TRICEPS',
    'BARBELL',
    'ADVANCED',
    'STRENGTH',
    'Use close hand placement.',
    'Maintain wrist alignment.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Resistance Band Pushdown',
    'Band triceps exercise.',
    'TRICEPS',
    'RESISTANCE_BAND',
    'BEGINNER',
    'STRENGTH',
    'Extend elbows downward.',
    'Control the return.',
    5,
    false,
    false,
    NULL,
    NULL
),

-- =========================
-- CORE
-- =========================

(
    'Plank',
    'Core stability exercise.',
    'ABS',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Hold a straight body position on forearms.',
    'Do not let hips sag.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Side Plank',
    'Targets obliques and core.',
    'OBLIQUES',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Support body on one forearm.',
    'Keep body aligned.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Crunch',
    'Classic abdominal exercise.',
    'ABS',
    'BODYWEIGHT',
    'BEGINNER',
    'HYPERTROPHY',
    'Lift shoulders off floor.',
    'Avoid pulling neck.',
    4,
    false,
    false,
    NULL,
    NULL
),

(
    'Bicycle Crunch',
    'Targets abs and obliques.',
    'ABS',
    'BODYWEIGHT',
    'BEGINNER',
    'STRENGTH',
    'Alternate elbow to opposite knee.',
    'Move slowly.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Russian Twist',
    'Rotational core exercise.',
    'OBLIQUES',
    'MEDICINE_BALL',
    'BEGINNER',
    'STRENGTH',
    'Rotate torso side to side.',
    'Keep core tight.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Leg Raise',
    'Lower abdominal exercise.',
    'ABS',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'STRENGTH',
    'Raise legs while lying flat.',
    'Do not arch lower back.',
    5,
    false,
    false,
    NULL,
    NULL
),

(
    'Hanging Leg Raise',
    'Advanced abdominal exercise.',
    'ABS',
    'BODYWEIGHT',
    'ADVANCED',
    'STRENGTH',
    'Raise legs while hanging.',
    'Avoid swinging.',
    7,
    false,
    false,
    NULL,
    NULL
),

(
    'Mountain Climbers',
    'Dynamic core exercise.',
    'ABS',
    'BODYWEIGHT',
    'BEGINNER',
    'HIIT',
    'Alternate knees toward chest.',
    'Maintain plank position.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Dead Bug',
    'Core stability exercise.',
    'ABS',
    'BODYWEIGHT',
    'BEGINNER',
    'MOBILITY',
    'Lower opposite arm and leg.',
    'Keep lower back pressed.',
    3,
    false,
    false,
    NULL,
    NULL
),

(
    'Bird Dog',
    'Core and lower back stability.',
    'LOWER_BACK',
    'BODYWEIGHT',
    'BEGINNER',
    'MOBILITY',
    'Extend opposite arm and leg.',
    'Keep hips level.',
    3,
    false,
    false,
    NULL,
    NULL
),

-- =========================
-- CARDIO
-- =========================

(
    'Treadmill Running',
    'Running on treadmill.',
    'CARDIO',
    'TREADMILL',
    'BEGINNER',
    'CARDIO',
    'Run at comfortable pace.',
    'Maintain posture.',
    12,
    true,
    false,
    NULL,
    NULL
),

(
    'Cycling',
    'Indoor cycling workout.',
    'CARDIO',
    'CYCLE',
    'BEGINNER',
    'CARDIO',
    'Pedal continuously.',
    'Adjust seat height.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Rowing Machine',
    'Full body cardio exercise.',
    'FULL_BODY',
    'ROWING_MACHINE',
    'INTERMEDIATE',
    'CARDIO',
    'Drive with legs then pull.',
    'Keep back straight.',
    11,
    true,
    false,
    NULL,
    NULL
),

(
    'Jump Rope',
    'High-intensity cardio.',
    'CARDIO',
    'BODYWEIGHT',
    'BEGINNER',
    'CARDIO',
    'Jump lightly on toes.',
    'Keep elbows close.',
    13,
    true,
    false,
    NULL,
    NULL
),

(
    'Burpees',
    'Full-body HIIT movement.',
    'FULL_BODY',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'HIIT',
    'Perform squat, plank, push-up and jump.',
    'Maintain rhythm.',
    14,
    true,
    false,
    NULL,
    NULL
),

(
    'Jumping Jacks',
    'Basic cardio movement.',
    'CARDIO',
    'BODYWEIGHT',
    'BEGINNER',
    'CARDIO',
    'Jump while raising arms.',
    'Land softly.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'High Knees',
    'Cardio warm-up.',
    'CARDIO',
    'BODYWEIGHT',
    'BEGINNER',
    'HIIT',
    'Run in place lifting knees.',
    'Pump arms.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Butt Kicks',
    'Cardio warm-up.',
    'CARDIO',
    'BODYWEIGHT',
    'BEGINNER',
    'CARDIO',
    'Kick heels toward glutes.',
    'Stay light on feet.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Elliptical',
    'Low-impact cardio.',
    'CARDIO',
    'ELLIPTICAL',
    'BEGINNER',
    'CARDIO',
    'Maintain steady pace.',
    'Use full stride.',
    9,
    true,
    false,
    NULL,
    NULL
),

(
    'Stair Climber',
    'Cardio and leg endurance.',
    'CARDIO',
    'MACHINE',
    'INTERMEDIATE',
    'CARDIO',
    'Climb continuously.',
    'Maintain posture.',
    11,
    true,
    false,
    NULL,
    NULL
),

-- =========================
-- FULL BODY
-- =========================

(
    'Thrusters',
    'Front squat into overhead press.',
    'FULL_BODY',
    'DUMBBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Squat then press overhead.',
    'Use controlled movement.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Clean and Press',
    'Olympic full body movement.',
    'FULL_BODY',
    'BARBELL',
    'ADVANCED',
    'STRENGTH',
    'Clean bar then press overhead.',
    'Focus on technique.',
    12,
    true,
    false,
    NULL,
    NULL
),

(
    'Kettlebell Swing',
    'Hip-dominant explosive exercise.',
    'FULL_BODY',
    'KETTLEBELL',
    'INTERMEDIATE',
    'STRENGTH',
    'Swing kettlebell using hip drive.',
    'Do not lift with arms.',
    10,
    true,
    false,
    NULL,
    NULL
),

(
    'Bear Crawl',
    'Functional full-body exercise.',
    'FULL_BODY',
    'BODYWEIGHT',
    'INTERMEDIATE',
    'MOBILITY',
    'Crawl forward keeping knees off floor.',
    'Maintain neutral spine.',
    8,
    true,
    false,
    NULL,
    NULL
),

(
    'Farmer Walk',
    'Grip and full-body exercise.',
    'FULL_BODY',
    'DUMBBELL',
    'BEGINNER',
    'STRENGTH',
    'Walk while carrying heavy weights.',
    'Keep shoulders back.',
    7,
    true,
    false,
    NULL,
    NULL
);