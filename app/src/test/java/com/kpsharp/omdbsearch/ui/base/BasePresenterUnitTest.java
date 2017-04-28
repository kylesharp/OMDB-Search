package com.kpsharp.omdbsearch.ui.base;

import com.kpsharp.omdbsearch.base.BaseUnitTest;
import com.kpsharp.omdbsearch.exceptions.ViewAlreadyAttachedException;
import com.kpsharp.omdbsearch.exceptions.ViewNotAttachedException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BasePresenterUnitTest extends BaseUnitTest {

    // region Variables

    private BasePresenter mBasePresenter;
    private BaseMvp.BaseView mBaseView;

    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    // endregion

    // region Lifecycle

    @Override
    public void setUp() throws Exception {

        super.setUp();

        mBasePresenter = new BasePresenter() {

            @Override
            public void subscribeToObservables() {
                // no-op
            }

            @Override
            public void unsubscribeFromObservables() {
                // no-op
            }
        };

        mBaseView = mock(BaseMvp.BaseView.class);

        mBasePresenter.attachView(mBaseView);
    }

    // endregion

    // region Tests

    @Test
    public void testGetView() throws Exception {

        assertSame(mBaseView, mBasePresenter.getView());
    }

    @Test
    public void testGetViewThrowsIfNoView() throws Exception {

        // Attached during setup
        mBasePresenter.detachView();

        mExpectedException.expect(ViewNotAttachedException.class);

        mBasePresenter.getView();
    }

    @Test
    public void testAttachView() throws Exception {

        // Attached during setup
        mBasePresenter.detachView();

        mBasePresenter.attachView(mBaseView);

        assertSame(mBaseView, mBasePresenter.getView());
    }

    @Test
    public void testAttachViewIfExistingView() throws Exception {

        mExpectedException.expect(ViewAlreadyAttachedException.class);

        mBasePresenter.attachView(mBaseView);
    }

    @Test
    public void testDetachView() throws Exception {

        // Would throw if did not work
        mBasePresenter.detachView();
    }

    @Test
    public void testDetachViewThrowsIfNoView() throws Exception {

        // Attached during setup
        mBasePresenter.detachView();

        mExpectedException.expect(ViewNotAttachedException.class);

        mBasePresenter.detachView();
    }

    @Test
    public void testIsAttached() throws Exception {

        assertTrue(mBasePresenter.isAttached());

        mBasePresenter.detachView();

        assertFalse(mBasePresenter.isAttached());
    }

    // endregion
}
