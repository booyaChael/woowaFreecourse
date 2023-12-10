### 프로그램 실행 : Application

✅ 프로그램 시작

### VendingMachine 생성 : Program

✅  자판기 금액 입력 받기 (Program - readMachineMoney)
  - 금액은 10원으로 나누어 떨어진다

✅ 자판기가 보유한 동전 계산하기 (Money - makeCoins)
   - RandomCoinGenerator의 makeRandomCoin 활용
✅ 자판기가 보유한 동전 출력하기
✅ 구입할 상품정보 입력 받기 (Program - readInventory)
   - 상품 가격은 100원부터 시작한다
   - 상품가격은 10원으로 나누어 떨어진다
   - 수량은 1 이상이어야 한다
   - 올바른 형식이어야 한다

### 상품 구입 : VendingMachine
✅투입금액 입력 받기 (VendingMachine - readUserMoney)
   - 10으로 나누어 떨어져야 한다
✅구매할 상품명 입력 받기 (VendingMachine - readProductToBuy)
   - VendingInventory에 있는 상품이어야 한다
   - 남은 금액이 상품의 최저가격보다 낮은지 확인
     - 상품의 남은 개수 확인
✅반환되는 동전 계산하기
   - 반환되는 동전은 최소 개수여야 한다
   - 자판기 내 동전이 부족한 경우, 반환 가능한 동전만 반환하며, 남은 액수는 자판기에 저장
✅반환되는 동전 출력하기